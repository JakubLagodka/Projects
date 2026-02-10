package it.unipol.crm.sinistro.persistence.service;

import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmClaimContractPersistenceService {
    @Autowired
    private UplCrmClaimContractRepository repository;

    @Transactional(value = "sinistroTransactionManager", propagation = Propagation.REQUIRES_NEW)
    public UplCrmClaimContract insertClaimContract(UplCrmClaimContract claimContract) {

        var now = new Timestamp(System.currentTimeMillis());
        claimContract.setLastUpdateDt(now);

        if (claimContract.getClaimId() == null || claimContract.getContractId() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "claimId = " + claimContract.getClaimId() + ", " +
                    "contractId = " + claimContract.getContractId());
        }

        final UplCrmClaimContract saved = repository.save(claimContract);

        log.debug("Inserted new claim contract, id = {}", saved.getClaimContrId());

        return saved;
    }
}