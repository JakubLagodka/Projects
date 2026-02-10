package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmDatiSocioeconomiciRepository extends JpaRepository<UplCrmDatiSocioeconomici, BigInteger> {
}
