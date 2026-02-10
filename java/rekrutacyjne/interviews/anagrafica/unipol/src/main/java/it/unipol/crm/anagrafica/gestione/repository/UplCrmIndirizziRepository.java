package it.unipol.crm.anagrafica.gestione.repository;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmIndirizzi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface UplCrmIndirizziRepository extends JpaRepository<UplCrmIndirizzi, BigInteger> {
}
