package Tema3.ActividadesFinales.Actividad4;

import java.io.Serializable;

// Clase Especialidad
class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombreEspe;

    public Especialidad(int id, String nombreEspe) {
        this.id = id;
        this.nombreEspe = nombreEspe;
    }

    @Override
    public String toString() {
        return "Especialidad: " + nombreEspe;
    }
}