import org.example.FindNumberInArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindNumberInArrayTest {
    @Test
    public void shouldReturnTargetIndexInArray() {
        //given
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        //when
        int index = findNumberInArray.findNumberInArray(array, target);
        //then
        assertEquals(4, index);
    }

    @Test
    public void shouldReturnFirstIndex() {
        //given
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] array = {2, 3, 4};
        int target = 1;
        //when
        int index = findNumberInArray.findNumberInArray(array, target);
        //then
        assertEquals(0, index);
    }

    @Test
    public void shouldReturnLastIndex() {
        //given
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] array = {1, 2, 3};
        int target = 1000;
        //when
        int index = findNumberInArray.findNumberInArray(array, target);
        //then
        assertEquals(3, index);
    }

    @Test
    public void shouldReturnNotExistingNumberIndex() {
        //given
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] array = {1, 2, 3, 5};
        int target = 4;
        //when
        int index = findNumberInArray.findNumberInArray(array, target);
        //then
        assertEquals(3, index);
    }

    @Test
    public void shouldReturnTargetIndexInArrayOdd() {
        //given
        FindNumberInArray findNumberInArray = new FindNumberInArray();
        int[] array = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int target = 7;
        //when
        int index = findNumberInArray.findNumberInArray(array, target);
        //then
        assertEquals(6, index);

//        int[] array = {1, 2, 3, 4, 5, 6, 8, 9, 10};
//        int target = 7;
//        Assertions.assertEquals(6, index);
    }
}