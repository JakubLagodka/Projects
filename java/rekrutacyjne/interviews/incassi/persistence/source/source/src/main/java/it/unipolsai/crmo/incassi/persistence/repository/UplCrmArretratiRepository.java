package it.unipolsai.crmo.incassi.persistence.repository;

import it.unipolsai.crmo.incassi.persistence.entity.UplCrmArretrati;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UplCrmArretratiRepository extends JpaRepository<UplCrmArretrati, BigInteger> {
    Optional<UplCrmArretrati> findByIdTitoloAndIdFolder(String idTitolo, BigInteger idFolder);
}
