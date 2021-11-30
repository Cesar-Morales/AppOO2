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

    @Before
    public void setUp() {
        TipoDeSuelo rootFamily = new Roots();
        papa = new Cultivo("Papa", 8.0, 88.6, 2.3, 25.0, "Root");
        cebolla = new Cultivo("Cebolla", 7.2, 80.3, 5.3, 25.0, "Amaryllidaceae");
        espacio = new Espacio("Campo", rootFamily);
    }

    //Acá debería tambien probar el constructor de Espacio para ver que el nombre
    //Es correcto y el tipo de suelo no está vacio?


    @Test
    public void testAgregarCultivo() {
        assertTrue(espacio.agregarCultivo(papa));
        assertFalse(espacio.agregarCultivo(cebolla));
    }

    //No se si esto va en el agregar o el listar
    //El listar es directamente devolver una lista
    //No hay mucho que probar
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
        
    }


}
