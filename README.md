# AppOO2

Este proyecto tiene como fin el desarrollo de un framework. El mismo permite crear una familia de aplicaciones las cuales sirven para administrar ciertos puntos pertienentes al manejo de un campo, controlar los tipos de cultivos que se pueden plantar en los distintos espacios de una quinta y los cultivos que hay en los distintos suelos.

Para insanciar el framework debemos especializar dos partes del framework. 

Primero crear una clase que extienda de la clase TipoDeSuelo. El framework viene con 2 clases como ejemplo para crear las propias y probar instanciar una aplicación.

Luego que tenemos los tipos de suelos que querramos en el main de nuestra clase MyApp hay que instanciar estos TiposDeSuelo. Luego instanciar de la clase Espacio la cantidad de objetos que querramos, para ello se debe hacer una composición con los tipos de suelos que creamos.

A continuación hay que crear una instancia de la clase Quinta y agregar todos los espacios que creamos y luego crear una instancia de la clase Menu pasandole esta quinta como parámetro.

Finalmente a la instancia de menu que creamos hay que enviarle el mensaje initApp().

Ya podemos compilar nuestra clase MyApp y correrla! Siga las instrucciones del menu para controlar su quinta.
