package com.mycompany.proyectoestructura;

public class NodoDoble {
 private Cancion dato;
 private NodoDoble nodoSig;
 private NodoDoble anterior;

 public NodoDoble(Cancion dato) {
  this.dato = dato;
 }
 
 public Cancion getDato() {
        return dato;
    }

    public void setDato(Cancion dato) {
        this.dato = dato;
    }

    public NodoDoble getNodoSig() {
        return nodoSig;
    }

    public void setNodoSig(NodoDoble nodoSig) {
        this.nodoSig = nodoSig;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
 
}
