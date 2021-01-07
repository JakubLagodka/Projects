package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Table(name = "rooms_type")
@Entity
public class RoomType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    private int number1;

    private int number2;

    private int number3;

    private int number4;

    private int number5;

    private int number6;

    private int number7;

    private int number8;

    private int number9;

    private int number10;

    private int number11;

    private int number12;

    private double number13;

    private double number14;

    private double number15;

    private double number16;

    private double number17;

    private double number18;

    private double number19;

    private double number20;

    private double number21;

    private double number22;

    private String string1;

    private String string2;

    private String string3;

    private String string4;

    private String string5;

    private String string6;

    private String string7;

    private String string8;

    private String string9;

    private String string10;

    private String string11;

    private String string12;

    private boolean boolean1;

    private boolean boolean2;

    private boolean boolean3;

    private boolean boolean4;

    private boolean boolean5;

    private boolean boolean6;

    private boolean boolean7;

    private boolean boolean8;

    private boolean boolean9;

    private boolean boolean10;

    private boolean boolean11;

    private boolean boolean12;

    public RoomType() {

    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public int getNumber4() {
        return number4;
    }

    public void setNumber4(int number4) {
        this.number4 = number4;
    }

    public int getNumber5() {
        return number5;
    }

    public void setNumber5(int number5) {
        this.number5 = number5;
    }

    public int getNumber6() {
        return number6;
    }

    public void setNumber6(int number6) {
        this.number6 = number6;
    }

    public int getNumber7() {
        return number7;
    }

    public void setNumber7(int number7) {
        this.number7 = number7;
    }

    public int getNumber8() {
        return number8;
    }

    public void setNumber8(int number8) {
        this.number8 = number8;
    }

    public int getNumber9() {
        return number9;
    }

    public void setNumber9(int number9) {
        this.number9 = number9;
    }

    public int getNumber10() {
        return number10;
    }

    public void setNumber10(int number10) {
        this.number10 = number10;
    }

    public int getNumber11() {
        return number11;
    }

    public void setNumber11(int number11) {
        this.number11 = number11;
    }

    public int getNumber12() {
        return number12;
    }

    public void setNumber12(int number12) {
        this.number12 = number12;
    }

    public double getNumber13() {
        return number13;
    }

    public void setNumber13(double number13) {
        this.number13 = number13;
    }

    public double getNumber14() {
        return number14;
    }

    public void setNumber14(double number14) {
        this.number14 = number14;
    }

    public double getNumber15() {
        return number15;
    }

    public void setNumber15(double number15) {
        this.number15 = number15;
    }

    public double getNumber16() {
        return number16;
    }

    public void setNumber16(double number16) {
        this.number16 = number16;
    }

    public double getNumber17() {
        return number17;
    }

    public void setNumber17(double number17) {
        this.number17 = number17;
    }

    public double getNumber18() {
        return number18;
    }

    public void setNumber18(double number18) {
        this.number18 = number18;
    }

    public double getNumber19() {
        return number19;
    }

    public void setNumber19(double number19) {
        this.number19 = number19;
    }

    public double getNumber20() {
        return number20;
    }

    public void setNumber20(double number20) {
        this.number20 = number20;
    }

    public double getNumber21() {
        return number21;
    }

    public void setNumber21(double number21) {
        this.number21 = number21;
    }

    public double getNumber22() {
        return number22;
    }

    public void setNumber22(double number22) {
        this.number22 = number22;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public String getString6() {
        return string6;
    }

    public void setString6(String string6) {
        this.string6 = string6;
    }

    public String getString7() {
        return string7;
    }

    public void setString7(String string7) {
        this.string7 = string7;
    }

    public String getString8() {
        return string8;
    }

    public void setString8(String string8) {
        this.string8 = string8;
    }

    public String getString9() {
        return string9;
    }

    public void setString9(String string9) {
        this.string9 = string9;
    }

    public String getString10() {
        return string10;
    }

    public void setString10(String string10) {
        this.string10 = string10;
    }

    public String getString11() {
        return string11;
    }

    public void setString11(String string11) {
        this.string11 = string11;
    }

    public String getString12() {
        return string12;
    }

    public void setString12(String string12) {
        this.string12 = string12;
    }

    public boolean isBoolean1() {
        return boolean1;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }

    public boolean isBoolean2() {
        return boolean2;
    }

    public void setBoolean2(boolean boolean2) {
        this.boolean2 = boolean2;
    }

    public boolean isBoolean3() {
        return boolean3;
    }

    public void setBoolean3(boolean boolean3) {
        this.boolean3 = boolean3;
    }

    public boolean isBoolean4() {
        return boolean4;
    }

    public void setBoolean4(boolean boolean4) {
        this.boolean4 = boolean4;
    }

    public boolean isBoolean5() {
        return boolean5;
    }

    public void setBoolean5(boolean boolean5) {
        this.boolean5 = boolean5;
    }

    public boolean isBoolean6() {
        return boolean6;
    }

    public void setBoolean6(boolean boolean6) {
        this.boolean6 = boolean6;
    }

    public boolean isBoolean7() {
        return boolean7;
    }

    public void setBoolean7(boolean boolean7) {
        this.boolean7 = boolean7;
    }

    public boolean isBoolean8() {
        return boolean8;
    }

    public void setBoolean8(boolean boolean8) {
        this.boolean8 = boolean8;
    }

    public boolean isBoolean9() {
        return boolean9;
    }

    public void setBoolean9(boolean boolean9) {
        this.boolean9 = boolean9;
    }

    public boolean isBoolean10() {
        return boolean10;
    }

    public void setBoolean10(boolean boolean10) {
        this.boolean10 = boolean10;
    }

    public boolean isBoolean11() {
        return boolean11;
    }

    public void setBoolean11(boolean boolean11) {
        this.boolean11 = boolean11;
    }

    public boolean isBoolean12() {
        return boolean12;
    }

    public void setBoolean12(boolean boolean12) {
        this.boolean12 = boolean12;
    }
/*public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }*/

   /* public long getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

    public void setNumberOfRoomsAvailable(long numberOfRoomsAvailable) {
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }*/
}
