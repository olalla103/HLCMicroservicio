package Tema3.ActividadesFinales.Actividad5.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

// Servidor UDP
class ServidorUDP {
    private static final int PUERTO = 50000;
    private static final Set<String> clientesConectados = new HashSet<>();

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servidor UDP iniciado...");
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                String clientKey = clientAddress.toString() + ":" + clientPort;

                if (!clientesConectados.contains(clientKey)) {
                    clientesConectados.add(clientKey);
                    System.out.println("=>Conecta IP " + clientAddress + ", Puerto remoto: " + clientPort);
                }

                String mensaje = new String(packet.getData(), 0, packet.getLength()).trim();
                if (mensaje.equals("bye")) {
                    System.out.println("  =>Desconecta IP " + clientAddress + ", Puerto remoto: " + clientPort);
                    clientesConectados.remove(clientKey);
                    continue;
                }

                // Responder con un mensaje de confirmación
                String respuesta = "Mensaje recibido en el servidor UDP";
                byte[] responseData = respuesta.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}