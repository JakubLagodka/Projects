package it.unipol.crm.sinistro.persistence.entity.claimrole;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Entity
@Table(name = "UPL_CRM_CLAIMROLE")
public class UplCrmClaimRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLAIM_ROLE_ID")
    private BigInteger claimRoleId;

    @Column(name = "CLAIM_ROLE_TP_CD")
    private BigInteger claimRoleTpCd;

    @Column(name = "CONT_ID")
    private BigInteger contId;

    @Column(name = "CLAIM_ID")
    private BigInteger claimId;

    @Column(name = "END_DT")
    private Timestamp endDt;

    @Column(name = "LAST_UPDATE_DT")
    private Timestamp lastUpdateDt;

    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;
}