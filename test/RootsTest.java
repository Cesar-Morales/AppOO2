import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RootsTest {
    
    private TipoDeSuelo tipoSuelo;
    private Cultivo papa;
    private Cultivo cebolla;
    
    @Before
    public void setUp() {
        papa = new Cultivo("Papa", 8.0, 88.6, 2.3, 25.0, "Root");
        cebolla = new Cultivo("Cebolla", 7.2, 80.3, 5.3, 25.0, "Amaryllidaceae");
        tipoSuelo = new Roots();
    }

    @Test
    public void testPuedePlantarse() {
        assertTrue(tipoSuelo.puedePlantarse(papa, 0.0));
        assertTrue(tipoSuelo.puedePlantarse(papa, 100.0));
        assertFalse(tipoSuelo.puedePlantarse(cebolla, 0.0));
    }

    @After
    public void tearDown() {
        tipoSuelo = null;
    }

}
