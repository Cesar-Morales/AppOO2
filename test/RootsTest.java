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
        papa = new Cultivo("Papa", 8.0, 88.6, 2.3, 25.0, "Root", 20.0, 12.0);
        cebolla = new Cultivo("Cebolla", 7.2, 80.3, 5.3, 25.0, "Amaryllidaceae", 33.1, 12.5);
        tipoSuelo = new Roots();
    }

    @Test
    public void testPuedePlantarse() {
        assertTrue(tipoSuelo.puedePlantarse(papa));
        assertTrue(tipoSuelo.puedePlantarse(papa));
        assertFalse(tipoSuelo.puedePlantarse(cebolla));
    }

    @After
    public void tearDown() {
        tipoSuelo = null;
        papa = null;
        cebolla = null;
    }

}
