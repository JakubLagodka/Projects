package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomiciPfErrori;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmDatiSocioeconomiciPfErroriRepository extends JpaRepository<UplCrmDatiSocioeconomiciPfErrori, BigInteger> {
}
