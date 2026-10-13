# Examen-Estructura
----INSTRUCCIONES EN COMPILACIÓN Y EJECUCIÓN EN EL PROGRAMA (CON MAVEN)----

Este proyecto está organizado en el paquete `com.mycompany.proyectoestructura`. 
Para poder compilarlo y ejecutarlo de forma correcta desde la terminal o comandos, se deben seguir los siguientes pasos:
1. Estructura de carpetas requerida:
     Primero debemos crear una carpeta raiz para el proyecto y dentro de ella una subcarpeta llamada `com/mycompany/proyectoestructura/`.
     Guardaremos cada clase en su archivo correpondiente dentro de esa ruta:
       - Cancion.java
       - NodoDoble.java
       - ListaReproduccion.java
       - Menu.java
       - ProyectoEstructura.java
2. Compilación:
     Abriremos nuestra terminal en la carpeta raiz de tu proyecto y ejecutaremos el siguiente comando.
        mvn clean compile
3. Ejecución:
     Nuestro archivo `pom.xml` ya tiene configurada la propiedad `<exec.mainClass>`, y gracias a esto podremos ejecutar directamente la aplicacion con el siguiente comando en Maven:
        mvn exec:java
             (Opcional: Si se desea ejecutar el menú interactivo en lugar de la prueba principal por defecto, debera crear una clase de prueba o invocar `Menu` desde `ProyectoEstructura`).

----CODIGO FUENTE DE LAS CLASES----
