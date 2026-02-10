package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmConvenzioni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmConvenzioniRepository extends JpaRepository<UplCrmConvenzioni, BigInteger> {
}
