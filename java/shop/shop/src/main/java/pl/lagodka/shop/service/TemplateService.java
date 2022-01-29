package pl.lagodka.shop.service;

import pl.lagodka.shop.model.dao.Template;

public interface TemplateService {

    Template findByName(String name);

    Template save(Template template);

}
