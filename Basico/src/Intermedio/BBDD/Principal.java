package Intermedio.BBDD;

import java.sql.Connection;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opcion = 0;
        do {
            //Menu
            System.out.println("---------------------------");
            System.out.println("Aplicacion de Personas");
            System.out.println("1.Crear Nueva Persona");
            System.out.println("2.Listar Personas");
            System.out.println("3.Editar Persona");
            System.out.println("4.Eliminar Persona");
            System.out.println("5.Salir");

            System.out.print(">> ");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:
                    PersonaService.CrearPersona();
                    break;
                case 2:
                    PersonaService.ReadPersona();
                    break;
                case 3:
                    PersonaService.UpdatePersona();
                    break;
                case 4:
                    PersonaService.DeletePersona();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion Incorrecta\n\n");
                    break;
            }
        } while (opcion != 5);

    }
}
