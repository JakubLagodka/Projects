package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnomalieAnagrafiche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmAnomalieAnagraficheRepository extends JpaRepository<UplCrmAnomalieAnagrafiche, BigInteger> {
}
