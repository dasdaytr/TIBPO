import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSearchFile extends Assert {
    private InitBytes bytes;
    @Before
    public void init(){
        bytes = new InitBytes();
    }
    @Test
    public void testGetAllOnesBytes(){
        assertEquals(0b11111111,bytes.getOnesBytes());
    }


    @Test
    public void testGetAllZeroBytes(){
        assertEquals(0b00000000,bytes.getZeroBytes());

    }




}
