import java.io.IOException;

public class TestApp {
    public static void main(String[] args) throws IOException {
        TipoDeSuelo tipoSuelo = new Roots();
		Espacio espacio = new Espacio("Campo", tipoSuelo);
		Quinta miQuinta = new Quinta("Quinta prueba");

        
        miQuinta.agregarEspacio(espacio);

        Menu menu = new Menu(miQuinta);

        menu.initApp();
    }
}
