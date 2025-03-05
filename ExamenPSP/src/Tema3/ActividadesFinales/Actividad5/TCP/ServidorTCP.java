package Tema3.ActividadesFinales.Actividad5.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Servidor TCP Multihilo
class ServidorTCP {
    private static final int PUERTO = 44444;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ManejadorCliente(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}