package it.unipol.crm.sinistro.persistence.entity.claimcontract;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "UPL_CRM_CLAIMCONTRACT")
public class UplCrmClaimContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLAIM_CONTR_ID")
    private BigInteger claimContrId;

    @Column(name = "CLAIM_ID")
    private BigInteger claimId;

    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;

    @Column(name = "LAST_UPDATE_DT")
    private Timestamp lastUpdateDt;

    @Column(name = "END_DT")
    private Timestamp endDt;

    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;
}