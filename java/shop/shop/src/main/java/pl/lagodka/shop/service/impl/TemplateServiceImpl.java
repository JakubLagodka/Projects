package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
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
}
