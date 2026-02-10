package it.unipolsai.crmo.incassi.persistence.repository;

import it.unipolsai.crmo.incassi.persistence.entity.UplCrmIncassiOnline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UplCrmIncassiOnlineRepository extends JpaRepository<UplCrmIncassiOnline, BigInteger> {
    Optional<UplCrmIncassiOnline> findByTitoloIdAndIdFolder(String idSecurity, BigInteger folderCode);
}
