# Examen-Estructura
----INTEGRANTES DEL EQUIPO QUE REALIZO EL PROGRAMA----
- Rodríguez Mejía Luis Angel (Grupo 1359)-
- Garcia Rosales Ailton Jesus (Grupo 1358)-
- Bartolini Betancourt Jonathan Absalon (Grupo 1358)-
- Gonzalez Morales Leonardo (Grupo 1358)-
- Martínez Pérez Julio Cesar (Grupo 1358)-

----INSTRUCCIONES EN COMPILACIÓN Y EJECUCIÓN EN EL PROGRAMA (CON MAVEN)----

-Requesitos previos:
     Tener en tu equipo Java Develpment Kit (JDK) 21 o superior instalado en tu equipo.
     Tener Apache Maven einstlado y configurado en las variables de entorno 
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

----FUNCIÓN Y EJECUCIÓN DEL PROGRAMA----

El presente programa es una simulación de una Lista de Reproducción de Música, basada en una estructura de datos de lista doblemente ligada circular.
Lo que nos permite gestionar canciones mediante un menú interactivo en consola.

-Funciones principales del menú (Operaciones del 1 al 13):

1. Agregar canción al inicio: Interta una nueva canción al final de la lista.
2. Agregar canción al final: Instertar una canción nueva al final de la lista.
3. Buscar canción por el ID: Permite localizar datos de la canción especifica mediante su identificador.
4. Seleccionar canción actual por medio de ID: Cambia el puntero de reproduccion actual a la canción que coincida con el ID ingresado.
5. Eliminar canción por medio de ID: Elimina una canción especifica de la lista buscando por su ID y ajusta los enlaces de los nodos seguidos.
6. Eliminar la canción actual: Borra la canción que se esta reproduciendo actualmente y avanza a la siguiente canción.
7. Consultar la canción actual: Muestra la información detallada de la canción seleccionada en ese momento.
8. Avanzar a la siguiente canción: Mueve el puntero al nodo siguiente en la lista.
9. Retroceder a la canción anterior: Mueve el puntero al nodo anterior en la lista.
10. Mostrar la lista completa: Imprime las canciones que estan almacenadas tanto en sentido de inicio a fin como de fin al inicio.
11. Consultar la cantidad de canciones: Muestra el tamaño total de elementos en la lista.
12. Simular la reproducción de k canciones: Realizara un recorrido automatico reproduciendo una k cantidad de canciones seguidas.
13. Salir: Finaliza la ejecución del programa.

Gracias por su atención y tenga lindo dia.
