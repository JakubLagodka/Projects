package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.model.dao.Template;
import pl.lagodka.shop.repository.TemplateRepository;
import pl.lagodka.shop.service.TemplateService;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    @Override
    public Template findByName(String name) {
        return templateRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(name));
    }

    @Override
    public Template save(Template template) {
        return templateRepository.save(template);
    }

    @Override
    public Template update(Template template, Long id) {
        Template templateDb = getById(id);
        templateDb.setName(template.getName());
        templateDb.setSubject(template.getSubject());
        templateDb.setBody(template.getBody());
        return templateDb;
    }

    @Override
    public void delete(Long id) {
        templateRepository.deleteById(id);
    }

    @Override
    public Template getById(Long id) {
        return templateRepository.getById(id);
    }

    @Override
    public Page<Template> getPage(Pageable pageable) {
        return templateRepository.findAll(pageable);
    }
}
