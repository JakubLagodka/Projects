package it.unipol.crm.attivita.batch.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface WccAttivitaRepository extends PagingAndSortingRepository<WccAttivita, BigInteger> {

}
