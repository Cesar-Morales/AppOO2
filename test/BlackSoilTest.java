import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BlackSoilTest {
    
    private TipoDeSuelo tipoSuelo;
    private Cultivo papa;
    private Cultivo cebolla;
    private Cultivo zanahoria;
    
    @Before
    public void setUp() {
        papa = new Cultivo("Papa", 8.0, 88.6, 2.3, 25.0, "Root", 20.0, 12.0);
        zanahoria = new Cultivo("zanahoria", 8.9, 90.6, 2.3, 24.0, "Root", 23.0, 22.0);
        cebolla = new Cultivo("Cebolla", 7.2, 80.3, 5.3, 25.0, "Amaryllidaceae", 33.1, 12.5);
        tipoSuelo = new BlackSoil();
    }

    @Test
    public void testPuedePlantarse() {
        assertTrue(tipoSuelo.puedePlantarse(zanahoria, 100.0));
        assertTrue(tipoSuelo.puedePlantarse(papa, 100.0));
        assertFalse(tipoSuelo.puedePlantarse(papa, 80.0));
        assertFalse(tipoSuelo.puedePlantarse(cebolla, 100.0));
        assertFalse(tipoSuelo.puedePlantarse(cebolla, 70.0));
    }

    @After
    public void tearDown() {
        tipoSuelo = null;
    }
}
