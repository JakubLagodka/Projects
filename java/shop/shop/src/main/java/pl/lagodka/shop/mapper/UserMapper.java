package pl.lagodka.shop.mapper;

import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.UserDto;

public interface UserMapper {
    User toDao(UserDto userDto);

    UserDto toDto(User user);
}
