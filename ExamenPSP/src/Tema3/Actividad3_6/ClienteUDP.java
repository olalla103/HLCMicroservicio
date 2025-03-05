package Tema3.Actividad3_6;

import java.net.*;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        String servidor = "127.0.0.1";
        int puerto = 5000;
        Scanner scanner = new Scanner(System.in);

        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000); // Tiempo de espera de 5 segundos
            System.out.println("Cliente UDP listo. Escribe un mensaje (* para salir):");

            while (true) {
                System.out.print("> ");
                String mensaje = scanner.nextLine();

                byte[] buffer = mensaje.getBytes();
                DatagramPacket paquete = new DatagramPacket(
                        buffer, buffer.length, InetAddress.getByName(servidor), puerto
                );
                socket.send(paquete);

                // Si el usuario ingresa "*", finaliza el cliente
                if (mensaje.trim().equals("*")) {
                    System.out.println("Cerrando cliente...");
                    break;
                }

                // Recibir respuesta del servidor
                byte[] bufferRespuesta = new byte[1024];
                DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);

                try {
                    socket.receive(paqueteRespuesta);
                    String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());
                    System.out.println("Respuesta del servidor: " + respuesta);
                } catch (SocketTimeoutException e) {
                    System.out.println("Tiempo de espera agotado. Paquete perdido.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
