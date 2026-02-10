package it.unipol.crm.sinistro.persistence.entity.claim;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "UPL_CRM_CLAIM")
public class UplCrmClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLAIM_ID")
    private BigInteger claimId;

    @Column(name = "ADMIN_REF_NUM")
    private String adminRefNum;

    @Column(name = "CLAIM_NUMBER")
    private String claimNumber;

    @Column(name = "CLAIM_DETAIL_AMT")
    private BigDecimal claimDetailAmt;

    @Column(name = "CLAIM_PAID_AMT")
    private BigDecimal claimPaidAmt;

    @Column(name = "OUTSTANDING_AMT")
    private BigDecimal outstandingAmt;

    @Column(name = "BENEFIT_CLAIM_AMT")
    private BigDecimal benefitClaimAmt;

    @Column(name = "CLAIM_TP_CD")
    private BigInteger claimTpCd;

    @Column(name = "LOB_TP_CD")
    private BigInteger lobTpCd;

    @Column(name = "CLAIM_STATUS_TP_CD")
    private BigInteger claimStatusTpCd;

    @Column(name = "CLAIM_CODE")
    private String claimCode;

    @Column(name = "STATUS_DT")
    private Timestamp statusDt;

    @Column(name = "CLAIM_INCURRED_DT")
    private Timestamp claimIncurredDt;

    @Column(name = "REPORTED_DT")
    private Timestamp reportedDt;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LAST_UPDATE_DT")
    private Timestamp lastUpdateDt;

    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;
}