package Tema3.Actividad3_5.Dinamico;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

// Clase para manejar cada cliente
class ManejadorCliente implements Runnable {
    private Socket cliente;
    private int numCliente;

    public ManejadorCliente(Socket cliente, int numCliente) {
        this.cliente = cliente;
        this.numCliente = numCliente;
    }

    @Override
    public void run() {
        try {
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            salida.println("Eres el cliente número " + numCliente);
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
