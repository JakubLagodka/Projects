package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.TemplateMapper;
import pl.lagodka.shop.model.dto.TemplateDto;
import pl.lagodka.shop.service.TemplateService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/templates")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class TemplateController {
    private final TemplateService templateService;

    private final TemplateMapper templateMapper;

    @PostMapping
    public TemplateDto saveTemplate(@RequestBody TemplateDto templateDto) {
        return templateMapper.toDto(templateService.save(templateMapper.toDao(templateDto)));
    }

    @GetMapping("/{id}")
    public TemplateDto getTemplateById(@PathVariable Long id) {
        return templateMapper.toDto(templateService.getById(id));
    }

    @GetMapping
    public Page<TemplateDto> getTemplatePage(@RequestParam int page, @RequestParam int size) {
        return templateService.getPage(PageRequest.of(page, size))
                .map(templateMapper::toDto);
    }

    @PutMapping("/{id}")
    public TemplateDto updateTemplate(@RequestBody @Valid TemplateDto templateDto, @PathVariable Long id) {
        return templateMapper.toDto(templateService.update(templateMapper.toDao(templateDto), id));
    }

    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable Long id) {
        templateService.delete(id);
    }
}
