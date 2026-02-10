package it.unipolsai.crmo.incassi.persistence.service;

import it.unipolsai.crmo.incassi.persistence.entity.UplCrmArretrati;
import it.unipolsai.crmo.incassi.persistence.repository.UplCrmArretratiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;

@Component
public class UplCrmArretratiService {
    @Autowired
    private UplCrmArretratiRepository uplCrmArretratiRepository;

    public UplCrmArretrati insertArretrati(UplCrmArretrati uplCrmArretrati) {
        var now = new Timestamp(System.currentTimeMillis());

        uplCrmArretrati.setLastUpdateDt(now);

        return uplCrmArretratiRepository.save(uplCrmArretrati);
    }

    public void deleteArretrati(BigInteger idArretrato) {
        uplCrmArretratiRepository.deleteById(idArretrato);
    }

    public BigInteger getIdArretratoFindedByIdSecurityAndFolderCode(String idSecurity, String folderCode) {
        if (folderCode == null) return null;
        var arretrato = uplCrmArretratiRepository.findByIdTitoloAndIdFolder(idSecurity, new BigInteger(folderCode));
        return arretrato.map(UplCrmArretrati::getIdArretrato).orElse(null);
    }
}
