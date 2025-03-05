package Tema3.Actividad3_5;

import java.io.*;
import java.net.*;

public class ServidorMulti {
    public static void main(String[] args) {
        int puerto = 5002;
        int maxClientes = 3;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexiones...");

            for (int i = 1; i <= maxClientes; i++) {
                Socket cliente = servidor.accept();
                System.out.println("Cliente " + i + " conectado.");

                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                salida.println("Eres el cliente número " + i);

                cliente.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
