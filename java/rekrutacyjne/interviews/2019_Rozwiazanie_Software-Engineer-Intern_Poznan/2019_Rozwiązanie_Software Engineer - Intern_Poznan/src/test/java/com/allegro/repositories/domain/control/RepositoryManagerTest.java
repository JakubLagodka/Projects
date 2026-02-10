package com.allegro.repositories.domain.control;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.allegro.repositories.domain.entity.RepositoryEntity;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@RunWith(SpringRunner.class)
public class RepositoryManagerTest {

    private static final String COMPANY_1 = "company1";
    private static final String COMPANY_2 = "company2";
    private static final String COMPANY_3 = "company3";

    @InjectMocks
    RepositoryManager repositoryManager;

    @Test
    public void shouldFindLastUpdatedRepositoryOfOrganization() {
        List<RepositoryEntity> mockListOfRepositories = createFirstMockListOfRepositories();
        List<RepositoryEntity> mockListOfRepositories2 = createSecondMockListOfRepositories();
        List<RepositoryEntity> mockListOfRepositories3 = createThirdMockListOfRepositories();
        List<RepositoryEntity> mockListOfRepositories4 = createFourthMockListOfRepositories();

        Assert.assertEquals(COMPANY_2, repositoryManager.findLastUpdatedRepository(mockListOfRepositories).get().getName());
        Assert.assertEquals(COMPANY_3, repositoryManager.findLastUpdatedRepository(mockListOfRepositories2).get().getName());
        Assert.assertEquals(COMPANY_1, repositoryManager.findLastUpdatedRepository(mockListOfRepositories3).get().getName());
        Assert.assertEquals(Optional.empty(), repositoryManager.findLastUpdatedRepository(mockListOfRepositories4));
    }

    private List<RepositoryEntity> createFirstMockListOfRepositories() {
        return ImmutableList.of(
                new RepositoryEntity(COMPANY_1, LocalDate.now()),
                new RepositoryEntity(COMPANY_2, LocalDate.now().minusDays(2)),
                new RepositoryEntity(COMPANY_3, LocalDate.now().plusDays(3))
        );
    }

    private List<RepositoryEntity> createSecondMockListOfRepositories() {
        return ImmutableList.of(
                new RepositoryEntity(COMPANY_1, LocalDate.now()),
                new RepositoryEntity(COMPANY_2, LocalDate.now().minusDays(2)),
                new RepositoryEntity(COMPANY_3, LocalDate.now().minusDays(4))
        );
    }

    private List<RepositoryEntity> createThirdMockListOfRepositories() {
        return ImmutableList.of(
                new RepositoryEntity(COMPANY_1, LocalDate.now().minusDays(10)),
                new RepositoryEntity(COMPANY_2, LocalDate.now()),
                new RepositoryEntity(COMPANY_3, LocalDate.now().minusDays(4))
        );
    }

    private List<RepositoryEntity> createFourthMockListOfRepositories() {
        return Collections.emptyList();
    }
}