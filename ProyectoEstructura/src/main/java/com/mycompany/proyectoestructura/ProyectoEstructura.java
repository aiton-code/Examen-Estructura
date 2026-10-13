package com.mycompany.proyectoestructura;

public class ProyectoEstructura {
    public static void main(String[] args) {
     Cancion A = new Cancion("lost", "penasio", 100);
     Cancion B = new Cancion("papa", "penasio", 100);
     Cancion C = new Cancion("mama", "penasio", 100);
     Cancion D = new Cancion("tio", "penasio", 100);
     Cancion E = new Cancion("tia", "penasio", 100);
     
     ListaReproduccion lista1 = new ListaReproduccion();
     
     lista1.agregarInicio(A);
     lista1.agregarInicio(B);
     lista1.agregarInicio(C);
     lista1.agregarInicio(D);
     lista1.agregarFinal(E);
     
     lista1.consultarLista(true);
     System.out.println("========================");
     
     lista1.eliminarPorID(3);
     
     System.out.println("========================");
     lista1.consultarLista(true);
     
    
    }
}
