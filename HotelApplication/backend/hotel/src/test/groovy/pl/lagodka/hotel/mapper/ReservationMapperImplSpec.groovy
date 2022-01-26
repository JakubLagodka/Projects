package pl.lagodka.hotel.mapper


import spock.lang.Specification

class ReservationMapperImplSpec extends Specification{
    def reservationMapper = new ReservationMapperImpl()

//    def 'should map reservation to reservationDto'() {
//        given:
//        def reservation = new Reservation(1, "TYPE_SINGLE", "Lagodka", "kuba", "password", "mail@gmail.com",
//                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
//                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan", [new Role(id: 1, name: "admin")])
//
//        when:
//        def result = reservationMapper.toDto(reservation)
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

    def 'should map reservation to reservationDto return null'(){
        given:
        def reservation = null

        when:
        def result = reservationMapper.toDto(reservation)

        then:
        result == null
    }

    def 'should map reservationDto to reservation return null'(){
        given:
        def reservationDto = null

        when:
        def result = reservationMapper.toDao(reservationDto)

        then:
        result == null
    }

//    def 'should map reservationDto to reservation'() {
//        given:
//        def reservationDto = new ReservationDto(1, "Jakub", "Lagodka", "kuba", "password", "password", "mail@gmail.com",
//                LocalDateTime.of(2022, 1, 6, 13, 30, 50), "kuba",
//                LocalDateTime.of(2022, 1, 5, 12, 40, 50), "jan",
//                RevisionMetadata.RevisionType.DELETE, 0)
//        when:
//        def result = reservationMapper.toDao(reservationDto)
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
