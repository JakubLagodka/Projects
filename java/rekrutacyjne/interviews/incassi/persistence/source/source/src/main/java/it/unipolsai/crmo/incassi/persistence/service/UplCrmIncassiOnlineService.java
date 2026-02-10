package it.unipolsai.crmo.incassi.persistence.service;

import it.unipolsai.crmo.incassi.persistence.entity.UplCrmIncassiOnline;
import it.unipolsai.crmo.incassi.persistence.repository.UplCrmIncassiOnlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;

@Component
public class UplCrmIncassiOnlineService {

    @Autowired
    private UplCrmIncassiOnlineRepository uplCrmIncassiOnlineRepository;

    public UplCrmIncassiOnline insertIncassiOnline(UplCrmIncassiOnline uplCrmIncassiOnline) {
        var now = new Timestamp(System.currentTimeMillis());

        uplCrmIncassiOnline.setLastUpdateDt(now);

        return uplCrmIncassiOnlineRepository.save(uplCrmIncassiOnline);
    }

    public BigInteger getIdIncassoFindedByIdSecurityAndFolderCode(String idSecurity, String folderCode) {
        if (folderCode == null) return null;
        var incasso = uplCrmIncassiOnlineRepository.findByTitoloIdAndIdFolder(idSecurity, new BigInteger(folderCode));
        return incasso.map(UplCrmIncassiOnline::getIncassoId).orElse(null);
    }
}
