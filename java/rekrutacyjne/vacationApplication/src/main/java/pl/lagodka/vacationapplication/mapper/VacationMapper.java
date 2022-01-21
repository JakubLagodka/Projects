package pl.lagodka.vacationapplication.mapper;

import org.mapstruct.Mapper;
import pl.lagodka.vacationapplication.model.dao.Vacation;
import pl.lagodka.vacationapplication.model.dto.VacationDto;

@Mapper(componentModel = "spring")
public interface VacationMapper {
    Vacation toDao(VacationDto vacationDto);

    VacationDto toDto(Vacation vacation);
}
