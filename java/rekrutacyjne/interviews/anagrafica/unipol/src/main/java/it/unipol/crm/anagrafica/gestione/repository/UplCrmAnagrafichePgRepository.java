package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagrafichePg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmAnagrafichePgRepository extends JpaRepository<UplCrmAnagrafichePg, BigInteger> {
}
