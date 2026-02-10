package it.unipol.crm.sinistro.persistence.entity.claimrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface UplCrmClaimRoleRepository extends JpaRepository<UplCrmClaimRole, BigInteger> {
    List<UplCrmClaimRole> findByClaimId(BigInteger claimId);

    // check if contact with given Id exists in CONTACT table
    @Query(value = "SELECT c.CONT_ID FROM CONTACT c WHERE c.CONT_ID = :contattoId", nativeQuery = true)
    BigInteger findContactId(@Param("contattoId") BigInteger contattoId);
}