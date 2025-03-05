package Tema3.ActividadesFinales.Actividad3;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

class ServidorUDP {
    private static final int PUERTO = 9876;
    private static final Map<String, Alumno> alumnos = new HashMap<>();

    static {
        Curso curso1 = new Curso("C1", "Matemáticas");
        Curso curso2 = new Curso("C2", "Historia");

        alumnos.put("A1", new Alumno("A1", "Juan Perez", curso1, 85));
        alumnos.put("A2", new Alumno("A2", "Maria Lopez", curso2, 90));
        alumnos.put("A3", new Alumno("A3", "Carlos Ruiz", curso1, 78));
        alumnos.put("A4", new Alumno("A4", "Ana Torres", curso2, 88));
        alumnos.put("A5", new Alumno("A5", "Luis Gomez", curso1, 92));
    }

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servidor UDP en espera de consultas...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String idalumno = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("Consulta recibida: " + idalumno);

                Alumno alumno = alumnos.getOrDefault(idalumno, new Alumno("N/A", "No encontrado", new Curso("N/A", "N/A"), -1));

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(alumno);
                oos.close();

                byte[] responseData = baos.toByteArray();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
