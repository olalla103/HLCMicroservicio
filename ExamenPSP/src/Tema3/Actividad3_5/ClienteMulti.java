package Tema3.Actividad3_5;

import java.io.*;
import java.net.*;

public class ClienteMulti {
    public static void main(String[] args) {
        String servidor = "127.0.0.1";
        int puerto = 5002;

        try (Socket socket = new Socket(servidor, puerto)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensaje = entrada.readLine();
            System.out.println("Mensaje del servidor: " + mensaje);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

