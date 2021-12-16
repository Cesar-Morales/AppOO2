import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EspacioTest {
    
    private Espacio espacio;
    private Cultivo papa;
    private Cultivo cebolla;

    //agrregar mocks
    @Before
    public void setUp() {
        TipoDeSuelo rootFamily = new Roots();
        papa = new Cultivo("Papa", 8.0, 14.0, 2.3, 25.0, "Root", 20.0, 12.0);
        cebolla = new Cultivo("Cebolla", 7.2, 80.3, 5.3, 25.0, "Amaryllidaceae", 22.0, 13.0);
        espacio = new Espacio("Campo", rootFamily);
    }

    @Test
    public void testAgregarCultivo() {
        assertTrue(espacio.agregarCultivo(papa));
        assertFalse(espacio.agregarCultivo(cebolla));
    }

    public void testListaCultivos(){
        assertEquals(0, espacio.listaDeCultivos().size());
        espacio.agregarCultivo(papa);
        assertEquals(1, espacio.listaDeCultivos().size());
        espacio.agregarCultivo(papa);
        assertEquals(1, espacio.listaDeCultivos().size());
        espacio.agregarCultivo(cebolla);
        assertEquals(1, espacio.listaDeCultivos().size());
    }

    @After
    public void tearDown() {
        papa = null;
        cebolla = null;
        espacio = null;
    }


}
