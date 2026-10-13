package com.mycompany.proyectoestructura;

import java.util.Scanner;

public class Menu {
    
 public void ejecutar() {
     
  this.MostrarMenu();
  int opcion = new Scanner(System.in).nextInt();
  System.out.print("Ingrese la opción que desee realizar: ");
  
  switch (opcion) {
   case 1:  agregar(true); break;
   case 2:  agregar(false); break;
   case 3:  buscar(); break;
   case 4:  seleccionar(); break;
   case 5:  eliminarPorId(); break;
   case 6:  eliminarActual(); break;
   case 7:  consultarActual(); break;
   case 8:  avanzar(); break;
   case 9:  retroceder(); break;
   case 10: mostrarLista(); break;
   case 11: consultarCantidad(); break;
   case 12: simularReproduccion(); break;
   case 13: System.out.println("Gracias por su preferencia. Hasta luego"); break;
   default: System.out.println("Error❌. Opción inválida. Por favor, ingrese un número del 1 al 13.");
  }
 }
 private void MostrarMenu() {
  System.out.println("===============Bienvenido a la lista de reproducción de canciones===============");
  System.out.println("1. Agregar canción al principio de la lista");
  System.out.println("2. Agregar canción al final de la lista");
  System.out.println("3. Buscar cancion por ID ");
  System.out.println("4. Seleccionar la cancion actual por ID");
  System.out.println("5. Eliminar cancion por ID");
  System.out.println("6. Eliminar la canción actual");
  System.out.println("7. Consultar la canción actual");
  System.out.println("8. Avanzar a la siguiente canción");
  System.out.println("9. Retroceder a la canción anterior");
  System.out.println("10. Mostrar la lista de canciones completa");
  System.out.println("11. Consultar la cantidad de canciones en la lista");
  System.out.println("12. Simular la reproduccion de k canciones");
  System.out.println("13. Salir");
  System.out.println("================================================================================");
 }
    
}
