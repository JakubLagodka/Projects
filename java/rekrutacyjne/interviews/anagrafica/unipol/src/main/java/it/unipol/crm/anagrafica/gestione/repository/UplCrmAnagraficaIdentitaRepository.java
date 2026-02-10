package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagraficaIdentita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmAnagraficaIdentitaRepository extends JpaRepository<UplCrmAnagraficaIdentita, BigInteger> {
}
