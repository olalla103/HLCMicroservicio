package Tema3.Actividad3_4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteCuadrado {
    public static void main(String[] args) {
        String servidor = "127.0.0.1";
        int puerto = 5001;
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket(servidor, puerto)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Introduce un número: ");
            int numero = scanner.nextInt();
            salida.println(numero);

            String respuesta = entrada.readLine();
            System.out.println("El cuadrado del número es: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
