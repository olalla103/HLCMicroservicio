package Tema3.Actividad3_8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class ServidorUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876)) {
            System.out.println("Servidor esperando datagrama...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Deserializar el objeto recibido
            ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Persona persona = (Persona) ois.readObject();
            ois.close();

            System.out.println("Servidor recibió: " + persona);

            // Modificar objeto
            persona.setEdad(persona.getEdad() + 5);
            System.out.println("Servidor modificó: " + persona);

            // Serializar y enviar de vuelta
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(persona);
            oos.close();

            byte[] responseData = baos.toByteArray();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}