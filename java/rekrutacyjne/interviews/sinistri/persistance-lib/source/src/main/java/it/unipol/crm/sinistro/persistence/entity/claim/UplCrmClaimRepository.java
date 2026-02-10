package it.unipol.crm.sinistro.persistence.entity.claim;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface UplCrmClaimRepository extends JpaRepository<UplCrmClaim, BigInteger> {

    List<UplCrmClaim> findByAdminRefNumAndReportedDtBetween(String adminRefNum, LocalDate reportedDtStart, LocalDate reportedDtEnd, Pageable pageable);

    @Query("SELECT claim FROM UplCrmClaim claim " +
            "JOIN UplCrmClaimRole rol ON claim.claimId = rol.claimId " +
            "JOIN UplCrmClaimContract con ON claim.claimId = con.claimId " +
            "WHERE (:adminRefNum is null or claim.adminRefNum = :adminRefNum) " +
            "AND rol.contId = :contattoId " +
            "AND (:contrattoId is null or con.contractId = :contrattoId) " +
            "AND (:reportedDtStart is null or claim.reportedDt >= :reportedDtStart) " +
            "AND (:reportedDtEnd is null or claim.reportedDt <= :reportedDtEnd) ")
    List<UplCrmClaim> findAllByAdminRefNumAndContattoIdAndContrattoIdAndReportedDtBetween
            (@Param("adminRefNum") String adminRefNum,
             @Param("contattoId") BigInteger contattoId,
             @Param("contrattoId") BigInteger contrattoId,
             @Param("reportedDtStart") Timestamp reportedDtStart,
             @Param("reportedDtEnd") Timestamp reportedDtEnd,
             Pageable pageable);


}