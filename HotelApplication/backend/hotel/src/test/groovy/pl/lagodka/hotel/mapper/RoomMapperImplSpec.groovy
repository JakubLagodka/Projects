package pl.lagodka.hotel.mapper


import spock.lang.Specification

class RoomMapperImplSpec extends Specification{
    def roomMapper = new RoomMapperImpl()

//    def 'should map room to roomDto'() {
//        given:
//        def room = new Room(1, "Jakub", "Lagodka", "kuba", "password", "mail@gmail.com",
//                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
//                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan", [new Role(id: 1, name: "admin")])
//
//        when:
//        def result = roomMapper.toDto(room)
//
//        then:
//        result.id == user.id
//        result.confirmPassword == null
//        result.createdBy == user.createdBy
//        result.createdDate == user.createdDate
//        result.firstName == user.firstName
//        result.lastModifiedBy == user.lastModifiedBy
//        result.lastModifiedDate == user.lastModifiedDate
//        result.lastName == user.lastName
//        result.login == user.login
//        result.mail == user.mail
//        result.password == null
//        result.revisionNumber == null
//        result.revisionType == null
//    }

    def 'should map room to roomDto return null'(){
        given:
        def room = null

        when:
        def result = roomMapper.toDto(room)

        then:
        result == null
    }

    def 'should map roomDto to room return null'(){
        given:
        def roomDto = null

        when:
        def result = roomMapper.toDao(roomDto)

        then:
        result == null
    }

//    def 'should map roomDto to room'() {
//        given:
//        def roomDto = new RoomDto(1, "Jakub", "Lagodka", "kuba", "password", "password", "mail@gmail.com",
//                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
//                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan",
//                RevisionMetadata.RevisionType.DELETE, 0)
//        when:
//        def result = roomMapper.toDao(roomDto)
//
//        then:
//        result.id == userDto.id
//        result.createdBy == userDto.createdBy
//        result.createdDate == userDto.createdDate
//        result.firstName == userDto.firstName
//        result.lastModifiedBy == userDto.lastModifiedBy
//        result.lastModifiedDate == userDto.lastModifiedDate
//        result.lastName == userDto.lastName
//        result.login == userDto.login
//        result.mail == userDto.mail
//        result.password == userDto.password
//        result.roles == null
//    }
}
