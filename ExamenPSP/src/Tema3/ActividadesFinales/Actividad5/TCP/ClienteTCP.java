package Tema3.ActividadesFinales.Actividad5.TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

// Cliente TCP para prueba
class ClienteTCP {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 44444;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Cliente conectado al servidor...");

            // Simula una conexión activa por unos segundos antes de cerrar
            Thread.sleep(5000);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}