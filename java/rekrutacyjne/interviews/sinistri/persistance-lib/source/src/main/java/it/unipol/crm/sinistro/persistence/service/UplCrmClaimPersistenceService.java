package it.unipol.crm.sinistro.persistence.service;

import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaim;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaimRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmClaimPersistenceService {
    @Autowired
    private UplCrmClaimRepository repository;

    @Transactional(value = "sinistroTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public UplCrmClaim insertClaim(UplCrmClaim claim) {

        var now = new Timestamp(System.currentTimeMillis());
        claim.setLastUpdateDt(now);

        if (claim.getClaimTpCd() == null) {
            throw new IllegalArgumentException("The following not-null field in insert object is null: " +
                    "claimTmCd = " + claim.getClaimTpCd());
        }

        final UplCrmClaim saved = repository.save(claim);

        log.debug("Inserted new claim, id = {}", saved.getClaimId());

        return saved;
    }
}