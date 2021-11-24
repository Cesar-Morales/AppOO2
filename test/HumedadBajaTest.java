
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HumedadBajaTest {
    
    @Before
    public void setUp() {
    	System.out.println("_______________________________________________________\n");
    	System.out.println("This is the setUp() method that runs before each testcase");
    }

    @Test
    public void test_JUnit1() {
        System.out.println("This is the testcase test_JUnit1() in this class");
    }

    @Test
    public void test_JUnit2() {
        System.out.println("This is the testcase test_JUnit2() in this class");
    }
 
    @Test
    public void test_JUnit3() {
        System.out.println("This is the testcase test_JUnit3() in this class");
    }

    @After
    public void tearDown() {
        System.out.println("This is the tearDown() method that runs after each testcase");
        System.out.println("_______________________________________________________\n");
    }

}
