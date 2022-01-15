package pl.lagodka.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDao(UserDto userDto);

    @Mapping(target = "password",ignore = true)
    UserDto toDto(User user);
}
