package it.unipol.crm.attivita.batch.writer;

import it.unipol.crm.attivita.batch.exception.WrongUpdateDateException;
import it.unipol.crm.attivita.batch.model.Action;
import it.unipol.crm.attivita.batch.model.FlagCaricato;
import it.unipol.crm.attivita.batch.model.WccAttivita;
import it.unipol.crm.attivita.batch.model.WccAttivitaRepository;
import it.unipol.crm.attivita.batch.stsclient.service.StsTokenService;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivitaRepository;
import it.unipol.crm.attivita.persistence.exceptions.AttivitaBatchException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import it.unipol.crm.attivita.persistence.service.UplCrmAttivitaPersistenceService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import static java.text.MessageFormat.format;

@Slf4j
@Component
public class WccAttivitaWriter implements ItemWriter<WccAttivita> {

    @Value("${BATCH_DB_UPDATE_USER}")
    private String updateUser;

    @Value("${STS_TOKEN}")
    private String token;

    @Value("${ATTIVITA_BATCH_NAME}")
    private String appName;

    @Autowired
    private StsTokenService stsTokenService;

    @Autowired
    private UplCrmAttivitaPersistenceService persistenceService;

    @Autowired
    private UplCrmAttivitaRepository uplCrmAttivitaRepository;

    @Autowired
    private WccAttivitaRepository wccAttivitaRepository;

    @Autowired
    protected ModelMapper mapper;

    @Override
    public void write(List<? extends WccAttivita> list) throws Exception {

        for (WccAttivita wccAttivita : list) {

            log.debug("WccAttivitaWriter, wccAttivita: {}", wccAttivita);

            try {
                UplCrmAttivita migratedAttivita = new UplCrmAttivita();

                if (isInsert(wccAttivita.getTipoOperazione())) {
                    migratedAttivita = insertNewAttivita(wccAttivita);
                }

                if (isUpdate(wccAttivita.getTipoOperazione())) {
                    migratedAttivita = updateExisitingAttivita(wccAttivita);
                }

                updateWccAttivitaAssociatOnSuccess(wccAttivita, migratedAttivita);

            } catch (AttivitaBatchException e) {
                updateWccOnException(wccAttivita, e, "Business error with custom error code. RequestId: {}", e.getErrorCode());

            } catch (WrongUpdateDateException e) {
                updateWccOnException(wccAttivita, e, "Wrong update dates on update. RequestId: {}", FlagCaricato.WRONG_UPDATE_DATE.getCode());

            } catch (Exception e) {
                updateWccOnException(wccAttivita, e, "Error with action, marking as unsuccessful. RequestId: {}", FlagCaricato.ERROR.getCode());
            }
        }
    }

    private UplCrmAttivita updateExisitingAttivita(WccAttivita wccAttivita) {
        UplCrmAttivita migratedAttivita;
        UplCrmAttivita newAttivita = mapper.map(wccAttivita, UplCrmAttivita.class);
        Optional<UplCrmAttivita> originalAttivita = uplCrmAttivitaRepository.findById(wccAttivita.getAttivitaId());

        if (originalAttivita.isPresent()) {
            if (areTimeStampsNotEqual(originalAttivita.get().getLastUpdateDt(), newAttivita.getLastUpdateDt())) {
                throw new WrongUpdateDateException(format("Attivita update dates do not match: original {0}, new {1}."
                        , originalAttivita.get().getLastUpdateDt(), newAttivita.getLastUpdateDt()));
            }
            migratedAttivita = originalAttivita.map(old -> updateFields(newAttivita, old))
                    .map(toUpdate -> {
                        toUpdate.setLastUpdateDt(new Timestamp(System.currentTimeMillis()));
                        toUpdate.setLastUpdateUser(updateUser);

                        log.debug("wccAttivita to be updated: {}", toUpdate);

                        return toUpdate;
                    })
                    .map(uplCrmAttivitaRepository::save)
                    .orElseThrow();
        } else {
            throw new NoSuchElementException(format("Not found Attivita for id {0}", newAttivita.getAttivitaId()));
        }
        return migratedAttivita;
    }

    private UplCrmAttivita insertNewAttivita(WccAttivita wccAttivita) throws NuovaAttivitaValidationException {
        UplCrmAttivita migratedAttivita;
        NuovaAttivita nuovaAttivita = mapper.map(wccAttivita, NuovaAttivita.class);

        log.debug("wccAttivita to be inserted: {}", nuovaAttivita);

        migratedAttivita = persistenceService.insertNuovaAttivita(nuovaAttivita,
                        updateUser,
                        stsTokenService.getToken(token).getToken(),
                        appName)
                .get(0);
        return migratedAttivita;
    }

    protected boolean isInsert(String tipoOperazione) {
        return Action.INSERT.getKey().equals(tipoOperazione);
    }

    protected boolean isUpdate(String tipoOperazione) {
        return Action.UPDATE.getKey().equals(tipoOperazione);
    }

    protected <T> T updateFields(T source, T destination) {
        mapper.map(source, destination);
        return destination;
    }

    private void updateWccAttivitaAssociatOnSuccess(WccAttivita wccAttivita, UplCrmAttivita uplCrmAttivita) {
        log.debug("Updating wccAttivita with success, id {}.", wccAttivita.getRequestId());
        wccAttivita.setFlgCaricato(FlagCaricato.SUCCESSFUL.getCode());
        wccAttivita.setUpdTimestamp(new Timestamp(System.currentTimeMillis()));
        wccAttivita.setAttivitaId(uplCrmAttivita.getAttivitaId());
        wccAttivitaRepository.save(wccAttivita);
    }

    private void updateWccOnException(WccAttivita wccwccAttivita, Exception e, String s, Integer code) {
        log.warn(s, wccwccAttivita.getRequestId(), e);
        wccwccAttivita.setFlgCaricato(code);
        wccwccAttivita.setUpdTimestamp(new Timestamp(System.currentTimeMillis()));
        wccAttivitaRepository.save(wccwccAttivita);
    }

    protected boolean areTimeStampsNotEqual(Timestamp lastUpdateDt, Timestamp lastUpdateDt1) {
        return !Objects.equals(lastUpdateDt, lastUpdateDt1);
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
