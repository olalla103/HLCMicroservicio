package Tema3.ActividadesFinales.Actividad3;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class ClienteUDP {
    private static final int PUERTO_SERVIDOR = 9876;
    private static final String SERVIDOR = "localhost";

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(); Scanner scanner = new Scanner(System.in)) {
            InetAddress serverAddress = InetAddress.getByName(SERVIDOR);

            while (true) {
                System.out.print("Ingrese el ID del alumno (* para salir): ");
                String idalumno = scanner.nextLine().trim();

                if (idalumno.equals("*")) break;

                byte[] sendData = idalumno.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PUERTO_SERVIDOR);
                socket.send(sendPacket);

                byte[] buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                Alumno alumno = (Alumno) ois.readObject();
                ois.close();

                System.out.println("Respuesta del servidor: \n" + alumno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
