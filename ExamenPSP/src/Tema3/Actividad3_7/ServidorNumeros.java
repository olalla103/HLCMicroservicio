package Tema3.Actividad3_7;

import java.io.*;
import java.net.*;

public class ServidorNumeros {
    public static void main(String[] args) {
        int puerto = 5000; // Puerto donde escucha el servidor

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                try (
                        Socket cliente = servidor.accept(); // Espera la conexión del cliente
                        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream()); // Recibe objetos
                        ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream()) // Envía objetos
                ) {
                    System.out.println("Cliente conectado.");

                    // Recibe el objeto Numeros del cliente
                    Numeros numeros = (Numeros) entrada.readObject();
                    System.out.println("Número recibido: " + numeros.getNumero());

                    // Si el número es <= 0, cierra el servidor
                    if (numeros.getNumero() <= 0) {
                        System.out.println("Número <= 0 recibido. Cerrando servidor...");
                        break;
                    }

                    // Calcula el cuadrado y el cubo
                    numeros.setCuadrado((long) Math.pow(numeros.getNumero(), 2));
                    numeros.setCubo((long) Math.pow(numeros.getNumero(), 3));

                    // Envía el objeto actualizado al cliente
                    salida.writeObject(numeros);
                    System.out.println("Resultados enviados al cliente.");

                } catch (ClassNotFoundException e) {
                    System.out.println("Error en la deserialización del objeto.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
