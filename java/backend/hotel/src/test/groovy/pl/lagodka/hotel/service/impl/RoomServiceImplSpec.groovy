package pl.lagodka.hotel.service.impl

import org.springframework.data.domain.Pageable
import pl.lagodka.hotel.model.dao.Room
import pl.lagodka.hotel.model.dao.RoomType
import pl.lagodka.hotel.repository.RoomRepository
import pl.lagodka.hotel.repository.RoomTypeRepository
import spock.lang.Specification

class RoomServiceImplSpec extends Specification{
    def roomRepository = Mock(RoomRepository)
    def roomTypeRepository = Mock(RoomTypeRepository)
    def roomService = new RoomServiceImpl(roomRepository, roomTypeRepository)

    def 'should return room by id'() {
        given:
        def id = 1

        when:
        roomService.getById(id)

        then:
        1 * roomRepository.getById(id)
        0 * _
    }

    def 'should delete room'() {
        given:
        def id = 1

        when:
        roomService.delete(id)

        then:
        1 * roomRepository.deleteById(id)
        0 * _
    }

    def 'should return page of rooms'() {
        given:
        def pageable = Mock(Pageable)

        when:
        roomService.getPage(pageable)

        then:
        1 * roomRepository.findAll(pageable)
        0 * _
    }

    def 'should save room'() {
        given:
        def room = Mock(Room)
        def roomType = new RoomType()

        when:
        roomService.create(room)

        then:
        1 * roomTypeRepository.findByName("TYPE_SINGLE") >> Optional.of(roomType)
        1 * room.setRoomTypes(Collections.singletonList(roomType))
        1 * roomRepository.save(room)
        0 * _
    }

    def 'should update room'() {
        given:
        def room = Mock(Room)
        def id = 1
        def roomDb = Mock(Room)

        when:
        roomService.update(room, id)

        then:
        1 * roomRepository.getById(id) >> roomDb
        1 * room.getPrice() >> 99.99
        1 * roomDb.setPrice(99.99)
        0 * _
    }


}
