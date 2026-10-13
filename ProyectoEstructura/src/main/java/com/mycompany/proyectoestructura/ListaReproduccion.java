package com.mycompany.proyectoestructura;

public class ListaReproduccion {
 private NodoDoble inicio;
 private NodoDoble actual;
 private NodoDoble fin;
 private int tamano;
 private int id;
 
 public ListaReproduccion() {
  this.inicio = null;
  this.actual = null;
  this.fin = null;
  this.tamano = 0;
 }
 
 public boolean vacia() {
  return tamano == 0;
 }
 
 public void agregarInicio (Cancion cancion){
     
  NodoDoble apoyo = new NodoDoble(cancion);
  tamano++;
  id++;
  apoyo.verCancion().asignarId(id);
  
  if (actual == null) 
  {
   actual = apoyo;
   inicio = actual;
   fin = actual;
   actual.conectarSiguiente(actual);
   actual.conectarAnterior(actual);
  } 
  else 
  {
   apoyo.conectarSiguiente(inicio);
   apoyo.conectarAnterior(fin);
   inicio.conectarAnterior(apoyo); 
   fin.conectarSiguiente(apoyo); 
   inicio = apoyo;
  }
 }
 
 public void agregarFinal(Cancion cancion){
  if (actual != null){
   NodoDoble apoyo = new NodoDoble(cancion);
   tamano++;
   id++;
   apoyo.verCancion().asignarId(id);
   apoyo.conectarAnterior(fin);
   fin.conectarSiguiente(apoyo);
   inicio.conectarAnterior(apoyo);
   apoyo.conectarSiguiente(inicio);
   fin = apoyo;
  }else System.out.println("Usar Agregar Inicio");
 }
 
public NodoDoble buscarNodoPorId(int id) {
 if (inicio == null) {
  return null;
 }
 
 NodoDoble buscador = inicio;
 for (int x = 0; x < tamano; x++) {
  if (buscador.verCancion().consultarId() == id) return buscador;
  buscador = buscador.verSiguiente();
 }
 return null;
}

public void reproducirCancionID(int id) {
 NodoDoble nodoEncontrado = this.buscarNodoPorId(id);
 if (nodoEncontrado != null) {
  actual = nodoEncontrado;
  System.out.println("Reproduciendo ahora: " + actual.verCancion());
 } else System.out.println("No se encontro la cancion con ID: " + id);
}
 
 public boolean eliminarPorID(int id) {
  if (inicio == null) {
   return false;
  }

  NodoDoble buscador = inicio;
  for (int x = 0; x < tamano; x++) {
   if (buscador.verCancion().consultarId() == id) {
    if (tamano == 1) {
     inicio = null;
     fin = null;
     actual = null;
     tamano = 0;
     return true;
    }
    
   NodoDoble anterior = buscador.verAnterior();
   NodoDoble siguiente = buscador.verSiguiente();
   anterior.conectarSiguiente(siguiente);
   siguiente.conectarAnterior(anterior);
   
   if (buscador == inicio) inicio = siguiente;
   if (buscador == fin) fin = anterior;
   if (buscador == actual) actual = siguiente;
   tamano--;
   return true;
   }
   buscador = buscador.verSiguiente();
  }

    return false;
}
 
 public void eliminarActual (){
  if (actual == null) {
   System.out.println("No hay canciones");
   return;
  }
  
  if (tamano == 1 || (inicio == fin && actual == inicio)) {
   inicio = null;
   fin = null;
   actual = null;
   tamano = 0;
   System.out.println("La lista se ha quedado sin canciones.");
   return;
  }
  
   NodoDoble anteriorNode = actual.verAnterior();
   NodoDoble siguienteNode = actual.verSiguiente();

   anteriorNode.conectarSiguiente(siguienteNode);
   siguienteNode.conectarAnterior(anteriorNode);

   if (actual == inicio) {
    inicio = siguienteNode;
   }
   if (actual == fin) {
    fin = anteriorNode;
   }
   
   tamano--;
   this.avanzarCancion();
   this.consultarLista(true);
 }
 
 public void avanzarCancion(){
  if(actual != null) actual = actual.verSiguiente();
  else System.out.println("No hay canciones");
 }
 
 public void retrocederCancion(){
  if(actual != null) actual = actual.verAnterior();
  else System.out.println("No hay canciones");
 }
 
 public void consultarLista(boolean avanzar){
  NodoDoble impresor;
  if(avanzar == true){
   impresor = inicio;
   for (int x = 0; x < tamano; x++){
    System.out.println(impresor.verCancion());
    impresor = impresor.verSiguiente();
   }
  }else{
   impresor = fin;
   for (int x = 0; x < tamano; x++){
    System.out.println(impresor.verCancion());
    impresor = impresor.verAnterior();
   }

  }
 }
 
 public int cantidadCanciones (){
  return tamano;
 }
 
 
 @Override
 public String toString(){
  return actual.toString();
 }

    public NodoDoble getActual() {
        return actual;
    }

    public void setActual(NodoDoble actual) {
        this.actual = actual;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
 
 
}
