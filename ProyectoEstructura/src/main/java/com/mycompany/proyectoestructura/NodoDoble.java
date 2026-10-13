package com.mycompany.proyectoestructura;

public class NodoDoble {
 private Cancion cancion;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(Cancion dato) {
    this.cancion = dato;
    }
 
    public Cancion verCancion() {
        return cancion;
    }

    public void conectarSiguiente(NodoDoble nodoSig) {
        this.siguiente = nodoSig;
    }
    
    public void desconectarSiguente (){
     this.siguiente = null;
    }

    public void conectarAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
    public void desconectarAnterior (){
     this.siguiente = null;
    }
    
    public NodoDoble verAnterior(){
     return anterior;
    }
    
    public NodoDoble verSiguiente (){
     return siguiente;
    }
    
    public void asignarCancion (Cancion cancion){
     this.cancion = cancion;
    }
    
    @Override
    public String toString(){
    return "Informacion: \n" + cancion.toString();
 }
}
