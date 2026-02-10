package query;


import org.junit.Test;

public class mainTest {

    @Test
    public void shouldNotValidMointain(){
        assert (Main.validMountainArray( new int[]{1,2,2,3,2} )==false);
        assert (Main.validMountainArray( new int[]{1,2,3,3,2} )==false);
    }

}