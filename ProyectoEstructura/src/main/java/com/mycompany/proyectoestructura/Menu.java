package com.mycompany.proyectoestructura;

import java.util.Scanner;

public class Menu {

    public void ejecutar() {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            MostrarMenu();
            opcion = leerEntero("Ingrese la opción que desee realizar: ");
            sout();
            switch (opcion) {
                case 1: agregar(true); break;
                case 2: agregar(false); break;
                case 3: buscar(); break;
                case 4: seleccionar(); break;
                case 5: eliminarPorId(); break;
                case 6: eliminarActual(); break;
                case 7: consultarActual(); break;
                case 8: avanzar(); break;
                case 9: retroceder(); break;
                case 10: mostrarLista(); break;
                case 11: consultarCantidad(); break;
                case 12: simularReproduccion(); break;
                case 13: System.out.println("Gracias por su preferencia. Hasta luego"); break;
                default: System.out.println("Error❌. Opción inválida. Por favor, ingrese un número del 1 al 13.");
            }
        } while (opcion != 13);
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
    private void agregar(boolean alInicio) {
        String nombre = leerTexto("Ingrese el nombre de la canción: ");
        String artista = leerTexto("Ingrese el nombre del artista: ");
        int duracion = leerEnteroPositivo("Ingrese la duración en segundos (mayor a 0): ");
 
        Cancion c = new Cancion(nombre, artista, duracion); // el ID se genera automáticamente
        boolean eraVacia = lista.estaVacia();
        if (alInicio) {
            lista.agregarAlInicio(c);
        } else {
            lista.agregarAlFinal(c);
        }
 
        System.out.println("Canción agregada " + (alInicio ? "al inicio" : "al final") + ": " + c);
        if (eraVacia) {
            System.out.println("Es la primera canción, por lo que ahora es la canción actual.");
        }
    }
 
    private void buscar() {
        if (avisarSiVacia()) return;
        int id = leerEntero("Ingrese el ID a buscar: ");
        Cancion c = lista.buscar(id);
        if (c == null) {
            System.out.println("Error❌. No existe una canción con ID " + id + ". La lista no fue modificada.");
        } else {
            System.out.println("Canción encontrada: " + c);
        }
    }
 
    private void seleccionar() {
        if (avisarSiVacia()) return;
        int id = leerEntero("Ingrese el ID de la canción a seleccionar: ");
        if (lista.seleccionar(id)) {
            System.out.println("Canción actual: " + lista.getActual());
        } else {
            System.out.println("Error❌. No existe una canción con ID " + id + ". La canción actual no cambió.");
        }
    }
 
    private void eliminarPorId() {
        if (avisarSiVacia()) return;
        int id = leerEntero("Ingrese el ID de la canción a eliminar: ");
        if (lista.eliminarPorId(id)) {
            System.out.println("Canción con ID " + id + " eliminada.");
            mostrarEstadoTrasEliminar();
        } else {
            System.out.println("Error❌. No existe una canción con ID " + id + ". La lista no fue modificada.");
        }
    }
 
    private void eliminarActual() {
        if (avisarSiVacia()) return;
        Cancion eliminada = lista.eliminarActual();
        System.out.println("Canción eliminada: " + eliminada);
        mostrarEstadoTrasEliminar();
    }
 
    private void consultarActual() {
        if (avisarSiVacia()) return;
        System.out.println("Canción actual: " + lista.getActual());
    }
 
    private void avanzar() {
        if (avisarSiVacia()) return;
        System.out.println("Avanzaste en la lista. Canción actual: " + lista.avanzar());
    }
 
    private void retroceder() {
        if (avisarSiVacia()) return;
        System.out.println("Retrocediste en la lista. Canción actual: " + lista.retroceder());
    }
 
    private void mostrarLista() {
        if (avisarSiVacia()) return;
        System.out.println("Del inicio al final");
        System.out.println(lista.listarAdelante());
        System.out.println("Del final al inicio");
        System.out.println(lista.listarAtras());
    }
 
    private void consultarCantidad() {
        System.out.println("Cantidad de canciones en la lista: " + lista.getTamanio());
    }
 
    private void simularReproduccion() {
        if (avisarSiVacia()) return;
        int k = leerEnteroPositivo("Ingrese la cantidad de canciones a reproducir (k > 0): ");
        System.out.print(lista.reproducir(k));
        System.out.println("Reproducción finalizada. Siguiente canción a reproducir: " + lista.getActual());
    }
    //Estado tras eliminar
private void mostrarEstadoTrasEliminar() {
    if (lista.vacia()) {
        System.out.println("La lista quedó vacía.");
    } else {
        System.out.println("Canción actual: " + lista.getActual());
    }
}

// Devuelve true y menciona cuando la lista esta vacia
private boolean avisarSiVacia() {
    if (lista.vacia()) {
        System.out.println("Error❌. La lista está vacía. Agregue canciones primero.");
        return true;
    }
    return false;
}

private String leerLinea(String mensaje) {
    System.out.print(mensaje);
    if (!scanner.hasNextLine()) {
        System.out.println("\nEntrada finalizada. Saliendo.");
        System.exit(0);
    }
    return scanner.nextLine().trim();
}

private String leerTexto(String mensaje) {
    String t;
    while ((t = leerLinea(mensaje)).isEmpty()) {
        System.out.println("Error❌. El texto no puede estar vacío.");
    }
    return t;
}

private int leerEntero(String mensaje) {
    while (true) {
        try {
            return Integer.parseInt(leerLinea(mensaje));
        } catch (NumberFormatException e) {
            System.out.println("Error❌. Entrada inválida. Escriba un número entero.");
        }
    }
}

private int leerEnteroPositivo(String mensaje) {
    int n;
    while ((n = leerEntero(mensaje)) <= 0) {
        System.out.println("Error❌. El valor debe ser mayor que cero.");
    }
    return n;
}
