package Tema3.Actividad3_4;

import java.io.*;
import java.net.*;

public class ServidorCuadrado {
    public static void main(String[] args) {
        int puerto = 5001;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexión...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado.");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            int numero;
            numero= Integer.parseInt(entrada.readLine());
            Math.abs(numero);
            System.out.println("Número recibido: " + numero);

            int cuadrado = numero * numero;
            salida.println(cuadrado);
            System.out.println("Enviando resultado: " + cuadrado);

            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
