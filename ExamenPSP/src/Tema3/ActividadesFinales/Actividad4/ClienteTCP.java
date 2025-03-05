package Tema3.ActividadesFinales.Actividad4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

// Cliente TCP
class ClienteTCP {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 6000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            int clienteId = in.readInt();
            System.out.println("Cliente " + clienteId + " conectado");

            while (true) {
                System.out.print("Ingrese el ID del profesor (* para salir): ");
                String input = scanner.nextLine().trim();

                if (input.equals("*")) {
                    out.writeInt(-1);
                    out.flush();
                    break;
                }

                int idProfesor = Integer.parseInt(input);
                out.writeInt(idProfesor);
                out.flush();

                Profesor profesor = (Profesor) in.readObject();
                System.out.println("Respuesta del servidor:\n" + profesor);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
