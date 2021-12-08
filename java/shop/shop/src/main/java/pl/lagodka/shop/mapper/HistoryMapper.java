package pl.lagodka.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.history.Revision;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.model.dto.UserDto;

@Mapper(componentModel = "spring")
public interface HistoryMapper {
    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.login", target = "login")
    @Mapping(source = "entity.firstName", target = "firstName")
    @Mapping(source = "entity.lastName", target = "lastName")
    @Mapping(source = "entity.mail", target = "mail")
    @Mapping(source = "metadata.revisionType", target = "revisionType")
    @Mapping(source = "requiredRevisionNumber", target = "revisionNumber")
    UserDto toUserDto(Revision<Integer, User> revision);

    @Mapping(source = "entity.id", target = "id")
    @Mapping(source = "entity.name", target = "name")
    @Mapping(source = "entity.price", target = "price")
    @Mapping(source = "entity.available", target = "isAvailable")
    @Mapping(source = "metadata.revisionType", target = "revisionType")
    @Mapping(source = "requiredRevisionNumber", target = "revisionNumber")
    ProductDto toProductDto(Revision<Integer, Product> revision);
}