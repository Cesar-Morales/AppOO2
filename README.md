# AppOO2

Este proyecto tiene como fin el desarrollo de un framework. El mismo permite crear una familia de aplicaciones las cuales sirven para administrar ciertos puntos pertienentes al manejo de un campo, controlar los tipos de cultivos que se pueden plantar en los distintos espacios de una quinta y los cultivos que hay en los distintos suelos.

Para insanciar el framework debemos especializar dos partes del framework. 

Primero crear una clase que extienda de la clase TipoDeSuelo. El framework viene con 2 clases como ejemplo para crear las propias y probar instanciar una aplicación. Para este ejemplo usaremos unas de estas que vienen como ejemplo, la clase Roots() la cual calcula si un cultivo es apto para el esapcio que tenga este tipo de suelo de acuerdo a una lista de nombre de cultivos aptos que posee.

Luego que tenemos los tipos de suelos que querramos se debe crear una clase MyApp donde en el main hay que instanciar estos TiposDeSuelo, una por cada tipo de suelo diferente que querramos en la app.

public class MyApp {
  public static void main(String[] args) {
    TipoDeSuelo tipoSuelo = new Roots();
  }
}

Luego se debe instanciar de la clase Espacio la cantidad de objetos que querramos, para ello se debe hacer una composición con los tipos de suelos que creamos. Esto definira que cuando se quieran agregar un cultivo a uno de estos espacios se permita o no plantarlo segun el tipo de suelo que posea.

public class MyApp {
  public static void main(String[] args) {
    TipoDeSuelo tipoSuelo = new Roots();
    Espacio espacio1 = new Espacio("Campo", tipoSuelo);
    Espacio espacio2 = new Espacio("Invernaculo", tipoSuelo);
  }
}

A continuación hay que crear una instancia de la clase Quinta y agregar todos los espacios que creamos y luego crear una instancia de la clase Menu pasandole esta quinta como parámetro.

public class MyApp {
  public static void main(String[] args) {
    TipoDeSuelo tipoSuelo = new Roots();
    Espacio espacioCampo = new Espacio("Campo", tipoSuelo);
    Espacio espacioInvernaculo = new Espacio("Invernaculo", tipoSuelo);
    miQuinta.agregarEspacio(espacioCampo);
    miQuinta.agregarEspacio(espacioInvernaculo);
    Menu menu = new Menu(miQuinta);
  }
}

Finalmente a la instancia de menu que creamos hay que enviarle el mensaje initApp(). Tener en cuenta que este metodo puede arrojar una excepción de tipo IOException por lo que hay que propagarla o manejarla.

public class MyApp {
  public static void main(String[] args) throws IOException {
    TipoDeSuelo tipoSuelo = new Roots();
    Espacio espacioCampo = new Espacio("Campo", tipoSuelo);
    Espacio espacioInvernaculo = new Espacio("Invernaculo", tipoSuelo);
    miQuinta.agregarEspacio(espacioCampo);
    miQuinta.agregarEspacio(espacioInvernaculo);
    Menu menu = new Menu(miQuinta);
  }
}

Ya podemos compilar nuestra clase MyApp y correrla! Siga las instrucciones del menu para controlar las acciones que desea realizar en su quinta.
