import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CultivoTest {

	private static Cultivo cultivo;
	private static Cultivo cultivo2;
	private static Quinta q;
	
	@BeforeAll
	public static void setUp() {
		q = new Quinta("Quinta de pepe");
		cultivo = new Cultivo("Papa", 10, 10, "unaFamilia", 10);
		//cultivo2 seteado para que pase la prueba en primavera
		//si no pasa cambiar la humedad para la estación actual
		cultivo2 = new Cultivo("Zanahoria", 10, 80, "unaFamilia", 10);
	}
	
	@Test
	void test() {
		assertFalse(q.getEstacion().cultivoApto(cultivo));
		assert(q.getEstacion().cultivoApto(cultivo2));
	}

}
