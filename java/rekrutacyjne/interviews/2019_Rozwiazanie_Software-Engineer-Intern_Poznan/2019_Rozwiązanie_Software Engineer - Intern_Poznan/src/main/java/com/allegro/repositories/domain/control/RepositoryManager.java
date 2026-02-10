package com.allegro.repositories.domain.control;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.allegro.repositories.domain.entity.RepositoryEntity;
import org.springframework.stereotype.Service;

@Service
public class RepositoryManager {

    public Optional<RepositoryEntity> findLastUpdatedRepository(List<RepositoryEntity> repositoriesFromUrl) {
        return repositoriesFromUrl.stream().min(getComparing());
    }

    private Comparator<RepositoryEntity> getComparing() {
        return Comparator.comparing(RepositoryEntity::getLatestUpdate);
    }
}