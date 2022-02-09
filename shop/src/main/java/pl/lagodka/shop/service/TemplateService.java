package pl.lagodka.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.shop.model.dao.Template;

public interface TemplateService {

    Template findByName(String name);

    Template save(Template template);

    Template update(Template template, Long id);

    void delete(Long id);

    Template getById(Long id);

    Page<Template> getPage(Pageable pageable);

}
