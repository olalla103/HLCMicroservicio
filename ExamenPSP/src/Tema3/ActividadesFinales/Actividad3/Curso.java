package Tema3.ActividadesFinales.Actividad3;

import java.io.Serializable;

// Clase Curso
class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String descripcion;

    public Curso(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() { return id; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return "Curso ID: " + id + ", Descripción: " + descripcion;
    }
}
