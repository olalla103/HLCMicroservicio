package Tema3.Actividad3_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        int puerto = 5000; // Puerto donde escuchará el servidor

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            // Aceptamos dos clientes
            for (int i = 1; i <= 2; i++) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente " + i + " conectado.");
                System.out.println("\tIP remota: " + cliente.getInetAddress().getHostAddress());
                System.out.println("\tPuerto remoto: " + cliente.getPort());
                System.out.println("\tPuerto local: " + cliente.getLocalPort());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
