import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class MainTest {

    @Test
    public void calculateFieldTest() {
        List<Integer> list = List.of(1,8,6,2,5,4,8,3,7);

        int calculate = Main.calculateField(list);

        Assertions.assertEquals(49, calculate);
    }

    @Test
    public void calculateField2Test() {
        List<Integer> list = List.of(1,8,6,2,5,4,8,3,7);

        int calculate = Main.calculateField2(list);

        Assertions.assertEquals(49, calculate);
    }

    @Test
    public void calculateField2aaTest() {
        List<Integer> list = List.of(1,1);

        int calculate = Main.calculateField2(list);

        Assertions.assertEquals(1, calculate);
    }

    @Test
    public void calculateField21Test() {
        List<Integer> list = List.of(1,1,1,1,1,1,3,3);

        int calculate = Main.calculateField2(list);

        Assertions.assertEquals(7, calculate);
    }
}