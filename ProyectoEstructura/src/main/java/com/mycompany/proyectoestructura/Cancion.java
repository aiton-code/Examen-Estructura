package com.mycompany.proyectoestructura;

public class Cancion {
    private int id;
    private String nombre;
    private String artista;
    private int duracion;

    public Cancion(String nombre, String artista, int duracion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Error❌. El nombre de la canción no puede estar vacío.");
        }
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("Error❌. El nombre del artista no puede estar vacío.");
        }
        if (duracion <= 0) {
            throw new IllegalArgumentException("Error❌. La duración de la canción debe ser mayor a cero.");
        }
 
        this.nombre = nombre.trim();
        this.artista = artista.trim();
        this.duracion = duracion;
    }   
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getArtista() { return artista; }
    public int getDuracion() { return duracion; }
    
    @Override
    public String toString() {
        return String.format("[ID: %d] %s - %s (%d : %02d)", id, nombre, artista, duracion / 60, duracion % 60);
    }
}
