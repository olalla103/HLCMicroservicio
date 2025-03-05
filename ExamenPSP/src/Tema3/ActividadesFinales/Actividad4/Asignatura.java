package Tema3.ActividadesFinales.Actividad4;

import java.io.Serializable;

// Clase Asignatura
class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombreAsig;

    public Asignatura(int id, String nombreAsig) {
        this.id = id;
        this.nombreAsig = nombreAsig;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombreAsig;
    }
}