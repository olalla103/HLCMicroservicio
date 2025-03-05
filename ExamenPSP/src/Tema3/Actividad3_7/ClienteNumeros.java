package Tema3.Actividad3_7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteNumeros {
    public static void main(String[] args) {
        String servidor = "127.0.0.1"; // Dirección del servidor (localhost)
        int puerto = 5000; // Puerto al que se conectará el cliente
        Scanner scanner = new Scanner(System.in);

        try (
                Socket socket = new Socket(servidor, puerto); // Conectar con el servidor
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream()); // Enviar objetos
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream()) // Recibir objetos
        ) {
            while (true) {
                // Pedir un número al usuario
                System.out.print("Introduce un número (<=0 para salir): ");
                int numero = scanner.nextInt();

                // Crear un objeto Numeros con el número ingresado
                Numeros numeros = new Numeros(numero);
                salida.writeObject(numeros); // Enviar el objeto al servidor

                // Si el número es <= 0, se cierra el cliente
                if (numero <= 0) {
                    System.out.println("Cerrando cliente...");
                    break;
                }

                // Recibir el objeto modificado del servidor
                numeros = (Numeros) entrada.readObject();
                System.out.println("Cuadrado: " + numeros.getCuadrado() + ", Cubo: " + numeros.getCubo());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
