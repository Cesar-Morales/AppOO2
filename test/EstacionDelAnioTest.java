import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EstacionDelAnioTest {

	private static EstacionDelAnio invierno, primavera, verano, otonio;
	private static Cultivo c1, c2;
	
	@BeforeAll
	public static void setUp() {
		invierno = Invierno.getSingletonInstance();
		otonio = Otonio.getSingletonInstance();
		verano = Verano.getSingletonInstance();
		primavera = Primavera.getSingletonInstance();
		//Cultivo que puede ser cultivado en primavera y otonio
		c1 = new Cultivo("Apio", 7.5, 14.0, 40.0, 18.0, "Familia Apio", 20.0, 12.0);
		//Cultivo que puede ser cultivado en verano e invierno
		c2 = new Cultivo("Pepino", 7.5, 8.0, 40.0, 22.0, "Familia Apio", 10.0, 20.0);
	}
	
	@Test
	void veranoTest() {
		assert(verano.cultivoApto(c2));
		assertFalse(verano.cultivoApto(c1));
	}
	
	@Test
	void otonioTest() {
		assert(otonio.cultivoApto(c1));
		assertFalse(otonio.cultivoApto(c2));
	}
	
	@Test
	void inviernoTest() {
		assert(invierno.cultivoApto(c2));
		assertFalse(invierno.cultivoApto(c1));
	}

	@Test
	void primaveraTest() {
		assert(primavera.cultivoApto(c1));
		assertFalse(primavera.cultivoApto(c2));
	}	

	
}
