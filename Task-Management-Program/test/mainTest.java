
import java.lang.reflect.Member;
import java.sql.Connection;
import static java.util.EnumSet.range;
import kernel.connection;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;
import kernel.logowanieController;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.Range;

import kernel.logowanieController;
import kernel.projektController;


/**
 *
 * @author Tomek
 */
public class mainTest {

  @Test
    public void connection() {
        
        Connection connect = connection.ConnectDB();    
        assertFalse(connect == null);
    }
    
  @Test
    public void hashTest(){
       
       String password = "test";
       logowanieController test = new logowanieController();
       assertEquals(test.getHash(password, "md5"),"098f6bcd4621d373cade4e832627b4f6");
    }
    
   @Test
    public void userLogin() {
        
        projektController test = new projektController();   
        assertFalse(test.getUserLogin("test") != null);
    }
    
    @Test
    public void projectID() {
        
        projektController test = new projektController();   
        assertFalse(test.getProjectId("1") != null);
    }
    
    @Test
    public void succesLogin() {
        
        projektController test = new projektController();   
        assertFalse(test.succesLogin("test") != true);
    }


}
