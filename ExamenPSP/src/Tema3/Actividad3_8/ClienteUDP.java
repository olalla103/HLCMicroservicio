package Tema3.Actividad3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Cliente UDP
class ClienteUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Crear objeto Persona
            Persona persona = new Persona("Juan", 25);
            System.out.println("Cliente envía: " + persona);

            // Serializar
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream objeto = new ObjectOutputStream(byteArray);
            objeto.writeObject(persona);
            objeto.close();

            byte[] sendData = byteArray.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            socket.send(sendPacket);

            // Recibir respuesta del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);

            // Deserializar respuesta
            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Persona personaModificada = (Persona) ois.readObject();
            ois.close();

            System.out.println("Cliente recibió: " + personaModificada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
