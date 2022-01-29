package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.shop.mapper.TemplateMapper;
import pl.lagodka.shop.model.dto.TemplateDto;
import pl.lagodka.shop.service.TemplateService;

@RestController
@RequestMapping("/api/templates")
@RequiredArgsConstructor
public class TemplateController {
    private final TemplateService templateService;

    private final TemplateMapper templateMapper;

    @PostMapping
    public TemplateDto saveTemplate(@RequestBody TemplateDto templateDto){
        return templateMapper.toDto(templateService.save(templateMapper.toDao(templateDto)));
    }
}
