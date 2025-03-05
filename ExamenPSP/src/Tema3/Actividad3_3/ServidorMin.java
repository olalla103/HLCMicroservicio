package Tema3.Actividad3_3;

import java.io.*;
import java.net.*;

public class ServidorMin {
    public static void main(String[] args) {
        int puerto = 5000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexión...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado.");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            String mensaje = "HOLA CLIENTE, ¿CÓMO ESTÁS?";
            System.out.println("Enviando: " + mensaje);
            salida.println(mensaje);

            String respuesta = entrada.readLine();
            System.out.println("Cliente responde en minúsculas: " + respuesta);

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
