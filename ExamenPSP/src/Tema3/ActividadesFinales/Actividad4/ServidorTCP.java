package Tema3.ActividadesFinales.Actividad4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

// Servidor TCP
class ServidorTCP {
    private static final int PUERTO = 6000;
    static final Map<Integer, Profesor> profesores = new HashMap<>();
    private static int contadorClientes = 1;

    static {
        Especialidad espe1 = new Especialidad(1, "Matemáticas");
        Especialidad espe2 = new Especialidad(2, "Historia");

        Asignatura[] asignaturas1 = {new Asignatura(101, "Álgebra"), new Asignatura(102, "Geometría")};
        Asignatura[] asignaturas2 = {new Asignatura(201, "Historia Antigua"), new Asignatura(202, "Historia Moderna")};

        profesores.put(1, new Profesor(1, "Carlos Pérez", asignaturas1, espe1));
        profesores.put(2, new Profesor(2, "María López", asignaturas2, espe2));
        profesores.put(3, new Profesor(3, "Juan Torres", asignaturas1, espe1));
        profesores.put(4, new Profesor(4, "Ana Gómez", asignaturas2, espe2));
        profesores.put(5, new Profesor(5, "Luis Ramírez", asignaturas1, espe1));
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente " + contadorClientes + " conectado");
                new ManejadorCliente(clientSocket, contadorClientes++).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

