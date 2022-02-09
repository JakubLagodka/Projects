package pl.lagodka.shop.mapper;

import org.mapstruct.Mapper;
import pl.lagodka.shop.model.dao.Template;
import pl.lagodka.shop.model.dto.TemplateDto;

@Mapper(componentModel = "spring")
public interface TemplateMapper {

    TemplateDto toDto(Template template);

    Template toDao(TemplateDto templateDto);
}
