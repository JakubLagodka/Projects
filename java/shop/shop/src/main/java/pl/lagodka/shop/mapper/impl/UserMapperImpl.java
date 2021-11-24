//package pl.lagodka.shop.mapper.impl;
//
//import org.springframework.stereotype.Component;
//import pl.lagodka.shop.mapper.UserMapper;
//import pl.lagodka.shop.model.dao.User;
//import pl.lagodka.shop.model.dto.UserDto;
//
//@Component
//public class UserMapperImpl implements UserMapper {
//    @Override
//    public User toDao(UserDto userDto) {
//        return User.builder()
//                .firstName(userDto.getFirstName())
//                .lastName(userDto.getLastName())
//                .login(userDto.getLogin())
//                .password(userDto.getPassword())
//                .build();
//    }
//
//    @Override
//    public UserDto toDto(User user) {
//        return UserDto.builder()
//                .id(user.getId())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .login(user.getLogin())
//                .build();
//    }
//}
