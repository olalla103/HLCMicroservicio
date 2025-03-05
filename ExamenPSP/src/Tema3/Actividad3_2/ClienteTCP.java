package Tema3.Actividad3_2;

import java.io.IOException;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        String servidor = "127.0.0.2"; // Dirección del servidor
        int puerto = 5000; // Puerto al que se conectará

        try (Socket socket = new Socket(servidor, puerto)) {
            System.out.println("Conectado al servidor.");
            System.out.println("\tIP remota: " + socket.getInetAddress().getHostAddress());
            System.out.println("\tPuerto remoto: " + socket.getPort());
            System.out.println("\tPuerto local: " + socket.getLocalPort());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}