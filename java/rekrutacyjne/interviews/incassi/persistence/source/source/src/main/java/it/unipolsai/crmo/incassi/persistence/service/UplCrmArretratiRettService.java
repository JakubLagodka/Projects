package it.unipolsai.crmo.incassi.persistence.service;

import it.unipolsai.crmo.incassi.persistence.entity.UplCrmArretratiRett;
import it.unipolsai.crmo.incassi.persistence.repository.UplCrmArretratiRettRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;

@Component
public class UplCrmArretratiRettService {
    @Autowired
    private UplCrmArretratiRettRepository uplCrmArretratiRettRepository;

    public UplCrmArretratiRett insertArretratiRett(UplCrmArretratiRett uplCrmArretratiRett) {
        var now = new Timestamp(System.currentTimeMillis());

        uplCrmArretratiRett.setLastUpdateDt(now);

        return uplCrmArretratiRettRepository.save(uplCrmArretratiRett);
    }


    public void deleteArretratiRett(BigInteger idArretrato) {
        uplCrmArretratiRettRepository.deleteById(idArretrato);
    }

    public BigInteger getIdArretratoRettFindedByIdSecurityAndFolderCode(String idSecurity, String folderCode) {
        if (folderCode == null) return null;
        var arretratoRett = uplCrmArretratiRettRepository.findByIdTitoloAndIdFolder(idSecurity, new BigInteger(folderCode));
        return arretratoRett.map(UplCrmArretratiRett::getIdArretrato).orElse(null);
    }
}
