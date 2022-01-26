package pl.lagodka.hotel.service.impl

import org.springframework.data.domain.Pageable
import pl.lagodka.hotel.model.dao.Reservation
import pl.lagodka.hotel.model.dao.RoomType
import pl.lagodka.hotel.repository.ReservationRepository

import spock.lang.Specification

class ReservationServiceImplSpec extends Specification{
    def reservationRepository = Mock(ReservationRepository)
    def reservationService = new ReservationServiceImpl(reservationRepository)

    def 'should return reservation by id'() {
        given:
        def id = 1

        when:
        reservationService.getById(id)

        then:
        1 * reservationRepository.getById(id)
        0 * _
    }

    def 'should delete reservation'() {
        given:
        def id = 1

        when:
        reservationService.delete(id)

        then:
        1 * reservationRepository.deleteById(id)
        0 * _
    }

    def 'should return page of reservations'() {
        given:
        def pageable = Mock(Pageable)

        when:
        reservationService.getPage(pageable)

        then:
        1 * reservationRepository.findAll(pageable)
        0 * _
    }

    def 'should save reservation'() {
        given:
        def reservation = Mock(Reservation)
        def reservationType = new RoomType()

        when:
        reservationService.create(reservation)

        then:
        1 * reservationRepository.save(reservation)
        0 * _
    }

    def 'should update reservation'() {
        given:
        def reservation = Mock(Reservation)
        def id = 1
        def reservationDb = Mock(Reservation)

        when:
        reservationService.update(reservation, id)

        then:
        1 * reservationRepository.getById(id) >> reservationDb
        1 * reservation.getPrice() >> 99.99
        1 * reservationDb.setPrice(99.99)
        0 * _
    }
}
