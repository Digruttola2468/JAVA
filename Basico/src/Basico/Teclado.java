package Basico;

import java.util.Scanner;

public class Teclado{

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        //Scanner con Int
        System.out.print("Dame un valor: ");
        int valor1 = teclado.nextInt();

        System.out.print("Dame un valor: ");
        int valor2 = teclado.nextInt();
        
        System.out.println(valor1 + " + " + valor2 + " = " + (valor1 + valor2) );

        //Scanner con String
        System.out.print("Nombre: ");
        String nombre = new Scanner(System.in).nextLine();

        System.out.print("Apellido: ");
        String apellido = new Scanner(System.in).nextLine();

        System.out.print("M o F: ");
        char genero = teclado.next().charAt(0);

        System.out.println("Nombre Completo: " + nombre + " " + apellido + "\nGenero: " + genero);

        //Scanner con Float
        System.out.print("Valor Float 1: ");
        float valor3 = teclado.nextFloat();

        System.out.print("Valor Float 2: ");
        float valor4 = teclado.nextFloat();
        
        System.out.println(valor3 + " + " + valor4 + " = " + (valor3 + valor4));
    }

}