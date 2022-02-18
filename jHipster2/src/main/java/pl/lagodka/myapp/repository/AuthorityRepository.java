package pl.lagodka.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.myapp.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
