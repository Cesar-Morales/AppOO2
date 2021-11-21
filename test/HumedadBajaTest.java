import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HumedadBajaTest {

    private HumedadBaja humedad;
    
    @Before
    public void setUp() {
        humedad = new HumedadBaja();
    }

    @Test
    public void testPuedePlantarse() {
        assertFalse(humedad.puedePlantarse("Tomate"));
        assertTrue(humedad.puedePlantarse("Cebolla"));
        assertTrue(humedad.puedePlantarse("Tomate"));
    }

    @After
    public void tearDown() {
        humedad = null;
    }

}
