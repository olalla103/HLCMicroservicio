package Tema3.ActividadesFinales.Actividad4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// Manejador de cliente
class ManejadorCliente extends Thread {
    private Socket socket;
    private int clienteId;

    public ManejadorCliente(Socket socket, int clienteId) {
        this.socket = socket;
        this.clienteId = clienteId;
    }

    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeInt(clienteId);
            out.flush();

            while (true) {
                int idProfesor = in.readInt();
                if (idProfesor == -1) break;
                System.out.println("Consultando id: " + idProfesor + ", solicitado por cliente: " + clienteId);

                Profesor profesor = ServidorTCP.profesores.getOrDefault(idProfesor,
                        new Profesor(-1, "No encontrado", new Asignatura[0], new Especialidad(-1, "N/A")));
                out.writeObject(profesor);
                out.flush();
            }
            System.out.println("Cliente " + clienteId + " ha finalizado");
        } catch (IOException e) {
            System.out.println("Cliente " + clienteId + " desconectado inesperadamente");
        }
    }
}

