/* Esta clase es el contrato que permite crear distintos tipos de suelo
de manera personalisada para nuestro propio framework.

En cada clase concretas usando los métodos de la clase Cultivo 
podemos obtener diferentes propiedades de estos que podemos declarar en
nuestrar clases concreatas y controlar.


*/

public interface TipoDeSuelo {

    boolean puedePlantarse(Cultivo cultivo);
    //Este creo que es un calculo más complicado, despues vemos si va o no.
    //Integer tiempoACosechar(List<Cultivo> cultivos);

}
