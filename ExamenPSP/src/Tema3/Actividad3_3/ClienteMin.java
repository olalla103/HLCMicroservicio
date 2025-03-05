package Tema3.Actividad3_3;

import java.io.*;
import java.net.*;

public class ClienteMin {
    public static void main(String[] args) {
        String servidor = "127.0.0.1";
        int puerto = 5000;

        try (Socket socket = new Socket(servidor, puerto)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje = entrada.readLine();
            System.out.println("Mensaje recibido: " + mensaje);

            String respuesta = mensaje.toLowerCase();
            salida.println(respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

