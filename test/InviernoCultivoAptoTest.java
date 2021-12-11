import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.function.Supplier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InviernoCultivoAptoTest {

	private EstacionDelAnio invierno;
	private Cultivo riegoMayorTemperaturaMayor, 
					riegoMayorTemperaturaIgual, 
					riegoMayorTemperaturaMenor, 
					riegoIgualTemperaturaMayor,
					riegoIgualTemperaturaIgual,
					riegoIgualTemperaturaMenor,
					riegoMenorTemperaturaMayor,
					riegoMenorTemperaturaIgual,
					riegoMenorTemperaturaMenor;
	private Calendar epocaInvierno;
	private Supplier<Calendar> fixedSuplierInvierno;


	@Before
	public void setUp() {

		epocaInvierno = Calendar.getInstance();
		epocaInvierno.set(Calendar.MONTH, 7);
		fixedSuplierInvierno = () -> epocaInvierno;

		invierno = new Invierno(fixedSuplierInvierno);

		riegoMayorTemperaturaMayor = new Cultivo("Papa1", 2.6, 14.9, 49.0, 15.2, "Familia raiz1", 20.0, 25.0);
		riegoMayorTemperaturaIgual = new Cultivo("Papa2", 7.6, 14.8, 48.0, 6.0, "Familia raiz2", 20.1, 26.0);
		riegoMayorTemperaturaMenor = new Cultivo("Papa3", 4.5, 14.6, 47.0, 1.3, "Familia raiz3", 20.3, 27.0); 
		riegoIgualTemperaturaMayor = new Cultivo("Papa4", 7.5, 14.0, 46.0, 15.0, "Familia raiz4", 20.4, 17.0);
		riegoIgualTemperaturaIgual = new Cultivo("Papa5", 3.5, 14.1, 45.0, 6.0, "Familia raiz5", 20.6, 17.0);
		riegoIgualTemperaturaMenor = new Cultivo("Papa6", 2.5, 14.3, 44.0, 1.6, "Familia raiz6", 20.7, 17.0);
		riegoMenorTemperaturaMayor = new Cultivo("Papa7", 7.1, 14.2, 43.0, 16.0, "Familia raiz7", 20.4, 3.0);
		riegoMenorTemperaturaIgual = new Cultivo("Papa8", 1.5, 24.0, 42.0, 6.0, "Familia raiz8", 20.8, 2.0);
		riegoMenorTemperaturaMenor = new Cultivo("Papa9", 7.2, 12.0, 41.0, 1.9, "Familia raiz9", 20.7, 1.0);
	}

	@Test
	public void cultivoAptoTest() {
		assert(invierno.puedePlantarseEnEstacion(riegoMayorTemperaturaMayor));
		assert(invierno.puedePlantarseEnEstacion(riegoMayorTemperaturaIgual));
		assert(invierno.puedePlantarseEnEstacion(riegoIgualTemperaturaMayor));
		assert(invierno.puedePlantarseEnEstacion(riegoIgualTemperaturaIgual));

		assertFalse(invierno.puedePlantarseEnEstacion(riegoMayorTemperaturaMenor));
		assertFalse(invierno.puedePlantarseEnEstacion(riegoIgualTemperaturaMenor));
		assertFalse(invierno.puedePlantarseEnEstacion(riegoMenorTemperaturaMayor));
		assertFalse(invierno.puedePlantarseEnEstacion(riegoMenorTemperaturaIgual));
		assertFalse(invierno.puedePlantarseEnEstacion(riegoMenorTemperaturaMenor));
	}
	
	@After
    public void tearDown() {
        invierno = null;
		fixedSuplierInvierno = null;
		epocaInvierno = null;
        riegoMayorTemperaturaMayor = null;
		riegoMayorTemperaturaIgual = null; 
		riegoMayorTemperaturaMenor = null;
		riegoIgualTemperaturaMayor = null;
		riegoIgualTemperaturaIgual = null;
		riegoIgualTemperaturaMenor = null;
		riegoMenorTemperaturaMayor = null;
		riegoMenorTemperaturaIgual = null;
		riegoMenorTemperaturaMenor = null;
    }
}
