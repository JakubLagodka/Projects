package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.RoomType;


public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int  int", nativeQuery = true)
    void createColumnInt();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int2  int", nativeQuery = true)
    void createColumnInt2();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int3  int", nativeQuery = true)
    void createColumnInt3();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int4  int", nativeQuery = true)

    void createColumnInt4();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int5  int", nativeQuery = true)
    void createColumnInt5();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int6  int", nativeQuery = true)
    void createColumnInt6();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int7  int", nativeQuery = true)
    void createColumnInt7();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int8  int", nativeQuery = true)
    void createColumnInt8();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int9  int", nativeQuery = true)
    void createColumnInt9();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int10  int", nativeQuery = true)
    void createColumnInt10();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int11  int", nativeQuery = true)
    void createColumnInt11();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int12  int", nativeQuery = true)
    void createColumnInt12();


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double double precision", nativeQuery = true)
    void createColumnDouble();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double2 double precision", nativeQuery = true)
    void createColumnDouble2();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double3 double precision", nativeQuery = true)
    void createColumnDouble3();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double4 double precision", nativeQuery = true)
    void createColumnDouble4();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double5 double precision", nativeQuery = true)
    void createColumnDouble5();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double6 double precision", nativeQuery = true)
    void createColumnDouble6();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double7 double precision", nativeQuery = true)
    void createColumnDouble7();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double8 double precision", nativeQuery = true)
    void createColumnDouble8();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double9 double precision", nativeQuery = true)
    void createColumnDouble9();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double10 double precision", nativeQuery = true)
    void createColumnDouble10();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double11 double precision", nativeQuery = true)
    void createColumnDouble11();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double12 double precision", nativeQuery = true)
    void createColumnDouble12();


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text1 text", nativeQuery = true)
    void createColumnString();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text2 text", nativeQuery = true)
    void createColumnString2();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text3 text", nativeQuery = true)
    void createColumnString3();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text4 text", nativeQuery = true)
    void createColumnString4();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text5 text", nativeQuery = true)
    void createColumnString5();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text6 text", nativeQuery = true)
    void createColumnString6();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text7 text", nativeQuery = true)
    void createColumnString7();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text8 text", nativeQuery = true)
    void createColumnString8();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text9 text", nativeQuery = true)
    void createColumnString9();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text10 text", nativeQuery = true)
    void createColumnString10();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text11 text", nativeQuery = true)
    void createColumnString11();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text12 text", nativeQuery = true)
    void createColumnString12();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text13 text", nativeQuery = true)
    void createColumnString13();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text14 text", nativeQuery = true)
    void createColumnString14();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text15 text", nativeQuery = true)
    void createColumnString15();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean boolean", nativeQuery = true)
    void createColumnBoolean();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean2 boolean", nativeQuery = true)
    void createColumnBoolean2();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean3 boolean", nativeQuery = true)
    void createColumnBoolean3();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean4 boolean", nativeQuery = true)
    void createColumnBoolean4();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean5 boolean", nativeQuery = true)
    void createColumnBoolean5();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean6 boolean", nativeQuery = true)
    void createColumnBoolean6();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean7 boolean", nativeQuery = true)
    void createColumnBoolean7();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean8 boolean", nativeQuery = true)
    void createColumnBoolean8();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean9 boolean", nativeQuery = true)
    void createColumnBoolean9();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean10 boolean", nativeQuery = true)
    void createColumnBoolean10();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean11 boolean", nativeQuery = true)
    void createColumnBoolean11();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean12 boolean", nativeQuery = true)
    void createColumnBoolean12();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean13 boolean", nativeQuery = true)
    void createColumnBoolean13();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean14 boolean", nativeQuery = true)
    void createColumnBoolean14();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN  int", nativeQuery = true)
    void deleteColumnInt();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int2", nativeQuery = true)
    void deleteColumnInt2();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int3", nativeQuery = true)
    void deleteColumnInt3();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int4", nativeQuery = true)

    void deleteColumnInt4();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int5", nativeQuery = true)
    void deleteColumnInt5();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int6 ", nativeQuery = true)
    void deleteColumnInt6();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int7 ", nativeQuery = true)
    void deleteColumnInt7();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int8 ", nativeQuery = true)
    void deleteColumnInt8();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int9 ", nativeQuery = true)
    void deleteColumnInt9();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int10 ", nativeQuery = true)
    void deleteColumnInt10();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int11 ", nativeQuery = true)
    void deleteColumnInt11();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN int12 ", nativeQuery = true)
    void deleteColumnInt12();


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double", nativeQuery = true)
    void deleteColumnDouble();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double2", nativeQuery = true)
    void deleteColumnDouble2();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double3", nativeQuery = true)
    void deleteColumnDouble3();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double4", nativeQuery = true)
    void deleteColumnDouble4();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double5", nativeQuery = true)
    void deleteColumnDouble5();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double6", nativeQuery = true)
    void deleteColumnDouble6();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double7", nativeQuery = true)
    void deleteColumnDouble7();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double8", nativeQuery = true)
    void deleteColumnDouble8();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double9", nativeQuery = true)
    void deleteColumnDouble9();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double10", nativeQuery = true)
    void deleteColumnDouble10();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double11", nativeQuery = true)
    void deleteColumnDouble11();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN double12", nativeQuery = true)
    void deleteColumnDouble12();


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text1", nativeQuery = true)
    void deleteColumnString();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text2", nativeQuery = true)
    void deleteColumnString2();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text3", nativeQuery = true)
    void deleteColumnString3();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text4", nativeQuery = true)
    void deleteColumnString4();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text5", nativeQuery = true)
    void deleteColumnString5();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text6", nativeQuery = true)
    void deleteColumnString6();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text7", nativeQuery = true)
    void deleteColumnString7();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text8", nativeQuery = true)
    void deleteColumnString8();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text9", nativeQuery = true)
    void deleteColumnString9();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text10", nativeQuery = true)
    void deleteColumnString10();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text11", nativeQuery = true)
    void deleteColumnString11();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text12", nativeQuery = true)
    void deleteColumnString12();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text13", nativeQuery = true)
    void deleteColumnString13();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text14", nativeQuery = true)
    void deleteColumnString14();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN text15", nativeQuery = true)
    void deleteColumnString15();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean", nativeQuery = true)
    void deleteColumnBoolean();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean2", nativeQuery = true)
    void deleteColumnBoolean2();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean3", nativeQuery = true)
    void deleteColumnBoolean3();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean4", nativeQuery = true)
    void deleteColumnBoolean4();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean5", nativeQuery = true)
    void deleteColumnBoolean5();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean6", nativeQuery = true)
    void deleteColumnBoolean6();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean7", nativeQuery = true)
    void deleteColumnBoolean7();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean8", nativeQuery = true)
    void deleteColumnBoolean8();    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean9", nativeQuery = true)
    void deleteColumnBoolean9();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean10", nativeQuery = true)
    void deleteColumnBoolean10();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean11", nativeQuery = true)
    void deleteColumnBoolean11();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean12", nativeQuery = true)
    void deleteColumnBoolean12();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean13", nativeQuery = true)
    void deleteColumnBoolean13();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type DROP COLUMN boolean14", nativeQuery = true)
    void deleteColumnBoolean14();






    default RoomType getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
