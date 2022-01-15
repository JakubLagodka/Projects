package pl.lagodka.shop.mapper;

import javax.annotation.processing.Generated;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.data.history.RevisionMetadata.RevisionType;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.model.dto.ProductDto.ProductDtoBuilder;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.model.dto.UserDto.UserDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-06T16:58:49+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public UserDto toUserDto(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( revisionEntityId( revision ) );
        userDto.login( revisionEntityLogin( revision ) );
        userDto.firstName( revisionEntityFirstName( revision ) );
        userDto.lastName( revisionEntityLastName( revision ) );
        userDto.mail( revisionEntityMail( revision ) );
        userDto.revisionType( revisionMetadataRevisionType( revision ) );
        userDto.revisionNumber( revision.getRequiredRevisionNumber() );

        return userDto.build();
    }

    @Override
    public ProductDto toProductDto(Revision<Integer, Product> revision) {
        if ( revision == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.id( revisionEntityId1( revision ) );
        productDto.name( revisionEntityName( revision ) );
        productDto.price( revisionEntityPrice( revision ) );
        productDto.isAvailable( revisionEntityAvailable( revision ) );
        productDto.revisionType( revisionMetadataRevisionType1( revision ) );
        productDto.revisionNumber( revision.getRequiredRevisionNumber() );

        return productDto.build();
    }

    private Long revisionEntityId(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }
        User entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        Long id = entity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String revisionEntityLogin(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }
        User entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        String login = entity.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String revisionEntityFirstName(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }
        User entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        String firstName = entity.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String revisionEntityLastName(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }
        User entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        String lastName = entity.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String revisionEntityMail(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }
        User entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        String mail = entity.getMail();
        if ( mail == null ) {
            return null;
        }
        return mail;
    }

    private RevisionType revisionMetadataRevisionType(Revision<Integer, User> revision) {
        if ( revision == null ) {
            return null;
        }
        RevisionMetadata<Integer> metadata = revision.getMetadata();
        if ( metadata == null ) {
            return null;
        }
        RevisionType revisionType = metadata.getRevisionType();
        if ( revisionType == null ) {
            return null;
        }
        return revisionType;
    }

    private Long revisionEntityId1(Revision<Integer, Product> revision) {
        if ( revision == null ) {
            return null;
        }
        Product entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        Long id = entity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String revisionEntityName(Revision<Integer, Product> revision) {
        if ( revision == null ) {
            return null;
        }
        Product entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        String name = entity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Double revisionEntityPrice(Revision<Integer, Product> revision) {
        if ( revision == null ) {
            return null;
        }
        Product entity = revision.getEntity();
        if ( entity == null ) {
            return null;
        }
        double price = entity.getPrice();
        return price;
    }

    private boolean revisionEntityAvailable(Revision<Integer, Product> revision) {
        if ( revision == null ) {
            return false;
        }
        Product entity = revision.getEntity();
        if ( entity == null ) {
            return false;
        }
        boolean available = entity.isAvailable();
        return available;
    }

    private RevisionType revisionMetadataRevisionType1(Revision<Integer, Product> revision) {
        if ( revision == null ) {
            return null;
        }
        RevisionMetadata<Integer> metadata = revision.getMetadata();
        if ( metadata == null ) {
            return null;
        }
        RevisionType revisionType = metadata.getRevisionType();
        if ( revisionType == null ) {
            return null;
        }
        return revisionType;
    }
}
