package Tema3.Actividad3_5.Dinamico;

import java.io.*;
import java.net.*;

public class ServidorDinamico {
    public static void main(String[] args) {
        int puerto = 5003;
        int maxClientes = 5; // Puedes cambiar este valor

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexiones...");

            for (int i = 1; i <= maxClientes; i++) {
                Socket cliente = servidor.accept();
                int numCliente = i;
                Thread hiloCliente = new Thread(new ManejadorCliente(cliente, numCliente));
                hiloCliente.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

