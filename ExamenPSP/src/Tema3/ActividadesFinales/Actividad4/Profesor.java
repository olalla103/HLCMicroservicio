package Tema3.ActividadesFinales.Actividad4;

import java.io.Serializable;
import java.util.Arrays;

// Clase Profesor
class Profesor implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idProfesor;
    private String nombre;
    private Asignatura[] asignaturas;
    private Especialidad especialidad;

    public Profesor(int idProfesor, String nombre, Asignatura[] asignaturas, Especialidad especialidad) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "ID Profesor: " + idProfesor + ", Nombre: " + nombre + "\n" +
                especialidad + "\nAsignaturas: " + Arrays.toString(asignaturas);
    }
}

