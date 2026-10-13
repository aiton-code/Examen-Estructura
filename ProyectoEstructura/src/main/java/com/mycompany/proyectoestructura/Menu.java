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
        sout("1. Agregar canción al principio de la lista");
        sout("2. Agregar canción al final de la lista");
        sout("3. Buscar cancion por ID ");
        sout("4. Seleccionar la cancion actual por ID");
        sout("5. Eliminar cancion por ID");
        sout("6. Eliminar la canción actual");
        sout("7. Consultar la canción actual");
        sout("8. Avanzar a la siguiente canción");
        sout("9. Retroceder a la canción anterior");
        sout("10. Mostrar la lista de canciones completa");
        sout("11. Consultar la cantidad de canciones en la lista");
        sout("12. Simular la reproduccion de k canciones");
        sout("13. Salir");
        sout("================================================================================");
    }
}
