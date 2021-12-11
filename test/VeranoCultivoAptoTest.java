import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VeranoCultivoAptoTest {

	private EstacionDelAnio verano;
	private Cultivo mayorAlRango, 
					bordeSuperiorRango, 
					dentroDelRango, 
					bordeInferiorRango,
					menorAlRango;
	private Calendar epocaVerano;
	private Supplier<Calendar> fixedSuplierVerano;


	@Before
	public void setUp() {

		epocaVerano = Calendar.getInstance();
		epocaVerano.set(Calendar.MONTH, 1);
		fixedSuplierVerano = () -> epocaVerano;

		verano = new Verano(fixedSuplierVerano);

		mayorAlRango = new Cultivo("Papa1", 2.6, 25.0, 49.0, 45.0, "Familia raiz1", 20.0, 25.0);
		bordeSuperiorRango = new Cultivo("Papa2", 7.2, 16.0, 48.0, 35.0, "Familia raiz2", 20.1, 26.0);
		dentroDelRango = new Cultivo("Papa3", 4.5, 12.0, 47.0, 26.0, "Familia raiz3", 20.3, 27.0); 
		bordeInferiorRango = new Cultivo("Papa4", 7.5, 10.0, 9.0, 19.0, "Familia raiz4", 20.4, 17.0);
		menorAlRango = new Cultivo("Papa5", 3.5, 2.0, 45.0, 3.0, "Familia raiz5", 20.6, 17.0);
	}

	@Test
	public void cultivoAptoTest() {
		assert(verano.puedePlantarseEnEstacion(bordeSuperiorRango));
		assert(verano.puedePlantarseEnEstacion(dentroDelRango));
		assert(verano.puedePlantarseEnEstacion(bordeInferiorRango));

		assertFalse(verano.puedePlantarseEnEstacion(mayorAlRango));
		assertFalse(verano.puedePlantarseEnEstacion(menorAlRango));
	}
	
	@After
    public void tearDown() {
        verano = null;
		fixedSuplierVerano = null;
		epocaVerano = null;
        bordeSuperiorRango = null;
		dentroDelRango = null; 
		bordeInferiorRango = null;
		mayorAlRango = null;
		menorAlRango = null;
    }
}
