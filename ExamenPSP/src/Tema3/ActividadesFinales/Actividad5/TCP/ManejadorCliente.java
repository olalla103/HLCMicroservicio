package Tema3.ActividadesFinales.Actividad5.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// Manejador de clientes
class ManejadorCliente extends Thread {
    private Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        InetAddress clientAddress = socket.getInetAddress();
        int clientPort = socket.getPort();
        System.out.println("=>Conecta IP " + clientAddress + ", Puerto remoto: " + clientPort);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Mantener la conexión activa hasta que el cliente cierre
            while (in.readLine() != null) {}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("  =>Desconecta IP " + clientAddress + ", Puerto remoto: " + clientPort);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}