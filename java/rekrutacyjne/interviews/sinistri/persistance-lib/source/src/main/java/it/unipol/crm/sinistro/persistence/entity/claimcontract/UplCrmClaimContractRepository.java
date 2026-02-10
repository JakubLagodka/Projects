package it.unipol.crm.sinistro.persistence.entity.claimcontract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface UplCrmClaimContractRepository extends JpaRepository<UplCrmClaimContract, BigInteger> {
    UplCrmClaimContract findByClaimId(BigInteger claimId);

    // check if contract with given Id exists in CONTRACT table
    @Query(value = "SELECT c.CONTRACT_ID FROM CONTRACT c WHERE c.CONTRACT_ID = :contrattoId", nativeQuery = true)
    BigInteger findContractId(@Param("contrattoId") BigInteger contrattoId);
}