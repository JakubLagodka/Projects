package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagraficaAgenzia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UplCrmAnagraficaAgenziaRepository extends JpaRepository<UplCrmAnagraficaAgenzia, BigInteger> {
}
