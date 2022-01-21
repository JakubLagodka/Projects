package pl.lagodka.vacationapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.lagodka.vacationapplication.model.dao.User;
import pl.lagodka.vacationapplication.model.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDao(UserDto userDto);

    @Mapping(target = "password",ignore = true)
    UserDto toDto(User user);
}
