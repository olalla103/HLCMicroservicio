package Tema3.Actividad3_6;

import java.net.*;

public class ServidorUDP {
    public static void main(String[] args) {
        int puerto = 5000;
        byte[] buffer = new byte[1024];
        boolean flag = true;

        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            System.out.println("Servidor UDP escuchando en el puerto " + puerto);

            while (flag) {
                DatagramPacket paqueteEntrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteEntrada);

                String mensaje = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                // Si el mensaje es "*", finaliza el servidor
                if (mensaje.trim().equals("*")) {
                    System.out.println("Cerrando servidor...");
                    flag = false;
                }

                // Convertir el mensaje a mayúsculas
                String respuesta = mensaje.toUpperCase();
                byte[] datosRespuesta = respuesta.getBytes();

                // Enviar respuesta al cliente
                DatagramPacket paqueteSalida = new DatagramPacket(
                        datosRespuesta, datosRespuesta.length,
                        paqueteEntrada.getAddress(), paqueteEntrada.getPort()
                );
                socket.send(paqueteSalida);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

