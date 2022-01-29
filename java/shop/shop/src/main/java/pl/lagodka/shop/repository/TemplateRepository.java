package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.shop.model.dao.Template;

import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template,Long> {

    Optional<Template> findByName(String name);
}
