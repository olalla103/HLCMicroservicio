package Tema3.ActividadesFinales.Actividad5.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
// Cliente UDP
class ClienteUDP {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 44444;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVIDOR);

            // Simular conexión
            String mensaje = "Hola servidor";
            byte[] sendData = mensaje.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PUERTO);
            socket.send(sendPacket);

            // Recibir respuesta del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);
            String respuesta = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

            // Simular desconexión
            String mensajeDesconexion = "bye";
            sendData = mensajeDesconexion.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PUERTO);
            socket.send(sendPacket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}