package it.unipol.crm.sinistro.persistence.service;

import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmClaimRolePersistenceService {
    @Autowired
    private UplCrmClaimRoleRepository repository;

    @Transactional(value = "sinistroTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public UplCrmClaimRole insertClaimRole(UplCrmClaimRole claimRole) {

        var now = new Timestamp(System.currentTimeMillis());
        claimRole.setLastUpdateDt(now);

        if (claimRole.getClaimRoleTpCd() == null || claimRole.getContId() == null || claimRole.getClaimId() == null) {
            throw new IllegalArgumentException("Some of the following not-null fields in insert object is null: " +
                    "claimRoleTpCd = " + claimRole.getClaimRoleTpCd() + ", " +
                    "contId = " + claimRole.getContId() + ", " +
                    "claimId = " + claimRole.getClaimId());
        }

        final UplCrmClaimRole saved = repository.save(claimRole);

        log.debug("Inserted new claim role, id = {}", saved.getClaimRoleId());

        return saved;
    }
}