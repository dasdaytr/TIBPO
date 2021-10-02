import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class TestSearchFile extends Assert {
    private SearchAndDeleteFile searchAndDeleteFile;
    @Before
    public void init(){
        File file = new File("ada");
        searchAndDeleteFile = new SearchAndDeleteFile(file);
    }
    @Test
    public void testGetAllOnesBytes(){
        assertEquals(0b1111111,new InitBytes().getOnes());
    }


    @Test
    public void testGetAllZeroBytes(){
        assertEquals(0b00000000,new InitBytes().getZeros());

    }

    @Test
    public void testDeleteFiles(){
        assertEquals(true,searchAndDeleteFile.startDeleteFiles());
    }




}
