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
   fin.desconectarSiguente();
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
   fin.desconectarSiguente();
   fin.conectarSiguiente(apoyo);
   inicio.desconectarAnterior();
   inicio.conectarAnterior(apoyo);
   fin = apoyo;
  }else System.out.println("Usar Agregar Inicio");
 }
 
 public Cancion buscarPorId(int id){
   NodoDoble buscador = inicio;
    for (int x = 0; x < tamano; x++)
     if (id != buscador.verCancion().consultarId()) buscador = buscador.verSiguiente();
     else return buscador.verCancion();
   return null;
 }
 
 public void reproducirCancionID(int id){
  Cancion cancionID = this.buscarPorId(id);
  if(cancionID != null) actual.asignarCancion(cancionID);
  else System.out.println("No se encontro la cancion");
 }
 
 public boolean eliminarPorID (int id){
  NodoDoble buscador = inicio;
  NodoDoble apoyo;
  for (int x = 0; x < tamano; x++)
   if (id == buscador.verCancion().consultarId()) {
    apoyo = buscador.verAnterior();
    buscador.desconectarAnterior();
    apoyo.desconectarSiguente();
    apoyo.conectarSiguiente(buscador.verSiguiente());
    buscador.verSiguiente().desconectarAnterior();
    buscador.verSiguiente().conectarAnterior(apoyo);
    buscador.desconectarSiguente();
    return true;
   }
   else buscador = buscador.verSiguiente();
  return false;
 }
 
 public void eliminarActual (){
  if(actual != null){
   NodoDoble apoyo;
   apoyo = actual.verAnterior();
   actual.desconectarAnterior();
   apoyo.desconectarSiguente();
   apoyo.conectarSiguiente(actual.verSiguiente());
   actual.verSiguiente().desconectarAnterior();
   actual.verSiguiente().conectarAnterior(apoyo);
   this.avanzarCancion();
   actual.desconectarSiguente();
   this.consultarLista(true);
  }else System.out.println("No hay canciones");
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
 
 @Override
 public String toString(){
  return actual.toString();
 }
}
