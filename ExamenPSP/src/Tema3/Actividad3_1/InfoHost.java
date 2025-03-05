package Tema3.Actividad3_1;

import java.net.*;
import java.util.Scanner;

public class InfoHost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un nombre de máquina o dirección IP: ");
        String input = scanner.nextLine();

        try {
            InetAddress address = InetAddress.getByName(input);

            System.out.println("\nInformación sobre: " + input);
            System.out.println("\tNombre del host: " + address.getHostName());
            System.out.println("\tDirección IP: " + address.getHostAddress());
            System.out.println("\tNombre de host canónico: " + address.getCanonicalHostName());
        } catch (UnknownHostException e) {
            System.out.println("No se pudo obtener información sobre: " + input);
            e.printStackTrace();
        }

        scanner.close();
    }
}