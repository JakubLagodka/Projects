package pl.lagodka.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dao.User.UserBuilder;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.model.dto.UserDto.UserDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-06T16:58:49+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDao(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( userDto.getId() );
        user.firstName( userDto.getFirstName() );
        user.lastName( userDto.getLastName() );
        user.login( userDto.getLogin() );
        user.password( userDto.getPassword() );
        user.mail( userDto.getMail() );
        user.createdDate( userDto.getCreatedDate() );
        user.createdBy( userDto.getCreatedBy() );
        user.lastModifiedDate( userDto.getLastModifiedDate() );
        user.lastModifiedBy( userDto.getLastModifiedBy() );

        return user.build();
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.login( user.getLogin() );
        userDto.mail( user.getMail() );
        userDto.createdDate( user.getCreatedDate() );
        userDto.createdBy( user.getCreatedBy() );
        userDto.lastModifiedDate( user.getLastModifiedDate() );
        userDto.lastModifiedBy( user.getLastModifiedBy() );

        return userDto.build();
    }
}
