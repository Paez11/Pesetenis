import iesfranciscodelosrios.pesetenis.model.dataobject.FileM;
import org.junit.Test;

import java.io.File;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class FileTest {

    @Test
    public void writeTest(){
        FileM filem = new FileM();
        String test = "test";
        String filter = " balance: ";
        assertEquals(true,filem.read(filter));
    }

    @Test
    public void readTest(){
        FileM filem = new FileM();
        String filter = " balance: ";
        Double account = 200010.0;
        Double balance = 0.0;
        balance=filem.readTest(filter);
        assertEquals(account,balance);
    }

}
