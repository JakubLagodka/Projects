package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmRecapiti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmRecapitiRepository extends JpaRepository<UplCrmRecapiti, BigInteger> {
}
