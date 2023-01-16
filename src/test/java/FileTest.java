import iesfranciscodelosrios.pesetenis.model.dataobject.FileM;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class FileTest {

    @Test
    public void writeTest(){
        FileM filem = new FileM();
        String test = "test";
        filem.write(test);
        assertEquals(true,filem.read());
    }
}
