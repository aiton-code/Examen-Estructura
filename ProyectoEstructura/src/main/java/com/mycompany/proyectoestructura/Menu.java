package com.mycompany.proyectoestructura;

import java.util.Scanner;

public class Menu {
    
 private ListaReproduccion lista = new ListaReproduccion();
 
 public void ejecutar() {
     
  this.MostrarMenu();
  System.out.print("Ingrese la opcion que desee realizar: ");
  int opcion = new Scanner(System.in).nextInt();
  
  
  switch (opcion) {
   case 1:  agregarInicio(this.inicializarLista()); break;
   case 2:  agregarFinal(this.inicializarLista()); break;
   case 3:  buscar(); break;
   case 4:  reproducir(); break;
   case 5:  eliminarPorId(); break;
   case 6:  eliminarActual(); break;
   case 7:  consultarActual(); break;
   case 8:  avanzar(); break;
   case 9:  retroceder(); break;
   case 10: mostrarLista(); break;
   case 11: consultarCantidad(); break;
   case 12: simularReproduccion(); break;
   case 13: System.out.println("Gracias por su preferencia. Hasta luego"); System.exit(0); break;
   default: System.out.println("Error❌. Opción inválida. Por favor, ingrese un número del 1 al 13.");
  }
 }
 private void MostrarMenu() {
  System.out.println("===============Bienvenido a la lista de reproduccion de canciones===============");
  System.out.println("1. Agregar cancion al principio de la lista");
  System.out.println("2. Agregar cancion al final de la lista");
  System.out.println("3. Buscar cancion por ID ");
  System.out.println("4. Reproducir cancion por ID");
  System.out.println("5. Eliminar cancion por ID");
  System.out.println("6. Eliminar la cancion actual");
  System.out.println("7. Consultar la cancion actual");
  System.out.println("8. Avanzar a la siguiente cancion");
  System.out.println("9. Retroceder a la cancion anterior");
  System.out.println("10. Mostrar la lista de canciones completa");
  System.out.println("11. Consultar la cantidad de canciones en la lista");
  System.out.println("12. Simular la reproduccion de k canciones");
  System.out.println("13. Salir");
  System.out.println("================================================================================");
 }
 
  public Cancion[] inicializarLista(){
   Cancion[] listaCanciones = {
        new Cancion("Bohemian Rhapsody", "Queen", 354),
        new Cancion("Stairway to Heaven", "Led Zeppelin", 482),
        new Cancion("Hotel California", "Eagles", 391),
        new Cancion("Billie Jean", "Michael Jackson", 294),
        new Cancion("Smells Like Teen Spirit", "Nirvana", 301),
        new Cancion("Imagine", "John Lennon", 183),
        new Cancion("Hey Jude", "The Beatles", 431),
        new Cancion("Sweet Child O' Mine", "Guns N' Roses", 356),
        new Cancion("Purple Rain", "Prince", 520),
        new Cancion("Like a Rolling Stone", "Bob Dylan", 369),
        new Cancion("Despacito", "Luis Fonsi", 228),
        new Cancion("Shape of You", "Ed Sheeran", 233),
        new Cancion("Blinding Lights", "The Weeknd", 200),
        new Cancion("Rolling in the Deep", "Adele", 228),
        new Cancion("Bad Guy", "Billie Eilish", 194),
        new Cancion("Uptown Funk", "Mark Ronson", 270),
        new Cancion("Viva La Vida", "Coldplay", 242),
        new Cancion("Lose Yourself", "Eminem", 326),
        new Cancion("Hallelujah", "Leonard Cohen", 276),
        new Cancion("Daft Punk", "Get Lucky", 248)
    };
   return listaCanciones;
  }
  
  private void agregarInicio(Cancion[] impresiones) {
   System.out.print("Seleciona la cancion que quieres agregar al inicio de la lista \n");
   for (int x = 0; x < impresiones.length; x++) System.out.print(x + " - " + impresiones[x] + "\n");
   int opcion = new Scanner(System.in).nextInt();
   if(opcion < 0 || opcion >= impresiones.length) {
    System.out.println("Error: Numero invalido. Debe ser un numero entre 0 y " + (impresiones.length - 1));
    this.agregarInicio(impresiones);
    return;
   }
   lista.agregarInicio(impresiones[opcion]);
   this.ejecutar();
  }

  private void agregarFinal(Cancion[] impresiones) {
   System.out.print("Seleciona la cancion que quieres agregar al final de la lista \n");
   for (int x = 0; x < impresiones.length; x++) System.out.print(impresiones[x] + "\n");
   int opcion = new Scanner(System.in).nextInt();
   if(opcion < 0 || opcion >= impresiones.length) {
    System.out.println("Error: Numero invalido. Debe ser un numero entre 0 y " + (impresiones.length - 1));
    this.agregarInicio(impresiones);
    return;
   }
   lista.agregarFinal(impresiones[opcion]);
   this.ejecutar();
  }

  private void buscar() {
   System.out.print("Colocar el ID de la cancion a buscar \n");
   int opcion = new Scanner(System.in).nextInt();
   NodoDoble eleccion = lista.buscarNodoPorId(opcion);
   if(eleccion != null) System.out.println(eleccion.verCancion());
   else System.out.println("No se encontro la cancion");
   this.ejecutar();
  }

  private void reproducir() {
   System.out.print("Colocar el ID de la cancion a reproducir \n");
   int opcion = new Scanner(System.in).nextInt();      
   NodoDoble eleccion = lista.reproducirCancionID(opcion);
   if (eleccion != null) System.out.println("Reproduciendo ahora: " + eleccion.verCancion());
   else System.out.println("No se encontro la cancion con ID: " + opcion);
   this.ejecutar();
  }

  private void eliminarPorId() {
   System.out.print("Colocar el ID de la cancion a eliminar \n");
   int opcion = new Scanner(System.in).nextInt();      
   if (lista.eliminarPorID(opcion)) System.out.print("Eliminacion Existosa");
   else System.out.print("No se encontro la cancion con el ID: " + opcion);
   this.ejecutar();
  }

  private void eliminarActual() {
   lista.eliminarActual();
   lista.consultarLista(true);
   this.ejecutar();
  }

  private void consultarActual() {
   System.out.print(lista.getActual().verCancion());
   this.ejecutar();
  }

  private void avanzar() {
   lista.avanzarCancion();
   this.ejecutar();
  }

  private void retroceder() {
   lista.retrocederCancion();
   this.ejecutar();
  }

  private void mostrarLista() {
   Scanner scanner = new Scanner(System.in);
   boolean opcionValida = false;
   boolean opcion = true;
    
   while (!opcionValida) {
    System.out.print("Colocar true para ver orden, Colocar false para ver en orden inverso: \n");
    if (scanner.hasNextBoolean()) {
     opcion = scanner.nextBoolean();
     opcionValida = true; 
    } else {
     System.out.println("Error: Debes escribir exactamente 'true' o 'false'. Intentalo de nuevo.\n");
     scanner.next();
    }
   }
    
    lista.consultarLista(opcion);
    this.ejecutar();
  }

  private void consultarCantidad() {
   System.out.print(lista.cantidadCanciones());
   this.ejecutar();
  }

  private void simularReproduccion() {
    if (lista.cantidadCanciones() == 0) {
        System.out.println("No hay canciones en la lista para simular reproducción.");
        this.ejecutar();
        return;
    }

    System.out.print("Ingrese la cantidad de canciones que desea reproducir de seguido: ");
    Scanner scanner = new Scanner(System.in);

    if (!scanner.hasNextInt()) {
        System.out.println("Error: Debe ingresar un número entero válido.");
        scanner.next();
        this.ejecutar();
        return;
    }

    int k = scanner.nextInt();
    if (k <= 0) {
        System.out.println("Error: La cantidad debe ser mayor a 0.");
        this.ejecutar();
        return;
    }

    System.out.println("\n Iniciando simulacion de reproduccion (" + k + " canciones)...\n");

    for (int i = 0; i < k; i++) {
        System.out.println("Reproduciendo [" + (i + 1) + "/" + k + "]: " + lista.getActual().verCancion());

        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Simulación interrumpida.");
        }

        lista.avanzarCancion();
    }

    System.out.println("\n Simulación finalizada.\n");
    this.ejecutar();
}
    
}
