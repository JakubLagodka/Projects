package it.unipolsai.crmo.incassi.persistence.repository;

import it.unipolsai.crmo.incassi.persistence.entity.UplCrmArretratiRett;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UplCrmArretratiRettRepository extends JpaRepository<UplCrmArretratiRett, BigInteger> {
    Optional<UplCrmArretratiRett> findByIdTitoloAndIdFolder(String idTitolo, BigInteger idFolder);
}
