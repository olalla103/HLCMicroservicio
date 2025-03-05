package Tema3.ActividadesFinales.Actividad3;

import java.io.Serializable;

// Clase Alumno
class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idalumno;
    private String nombre;
    private Curso curso;
    private int nota;

    public Alumno(String idalumno, String nombre, Curso curso, int nota) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
    }

    public String getIdalumno() { return idalumno; }
    public String getNombre() { return nombre; }
    public Curso getCurso() { return curso; }
    public int getNota() { return nota; }

    @Override
    public String toString() {
        return "ID Alumno: " + idalumno + ", Nombre: " + nombre + ", Nota: " + nota + "\n" + curso;
    }
}