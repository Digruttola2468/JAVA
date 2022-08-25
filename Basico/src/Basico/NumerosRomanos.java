package Basico;

import java.util.Scanner;

public class NumerosRomanos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("--------NUMERO A NUMERO ROMANO--------");

        System.out.print("Numero: ");
        String numeroString = teclado.nextLine();

        int numero = Integer.parseInt(numeroString);
        int centena = numero / 100;
        int decena  = (numero - (centena * 100)) / 10;
        int unidad  = numero - (centena * 100) - (decena * 10);

        //I -> 1
        //V -> 5
        //X -> 10
        //L -> 50
        //C -> 100
        //D -> 500
        //M -> 1000

        String stringRomano = "-";
        switch (centena) {
            case 1:
                stringRomano += "C";
                break;
            case 2:
                stringRomano += "CC";
                break;
            case 3:
                stringRomano += "CCC";
                break;
            case 4:
                stringRomano += "CD";
                break;
            case 5:
                stringRomano += "D";
                break;
            case 6:
                stringRomano += "DC";
                break;
            case 7:
                stringRomano += "DCC";
                break;
            case 8:
                stringRomano += "DCCC";
                break;
            case 9:
                stringRomano += "CM";
                break;
        }

        switch (decena) {
            case 1:
                stringRomano += "X";
                break;
            case 2:
                stringRomano += "XX";
                break;
            case 3:
                stringRomano += "XXX";
                break;
            case 4:
                stringRomano += "XL";
                break;
            case 5:
                stringRomano += "L";
                break;
            case 6:
                stringRomano += "LX";
                break;
            case 7:
                stringRomano += "LXX";
                break;
            case 8:
                stringRomano += "LXXX";
                break;
            case 9:
                stringRomano += "XC";
                break;
        }

        switch (unidad) {
            case 1:
                stringRomano += "I";
                break;
            case 2:
                stringRomano += "II";
                break;
            case 3:
                stringRomano += "III";
                break;
            case 4:
                stringRomano += "IV";
                break;
            case 5:
                stringRomano += "V";
                break;
            case 6:
                stringRomano += "VI";
                break;
            case 7:
                stringRomano += "VII";
                break;
            case 8:
                stringRomano += "VIII";
                break;
            case 9:
                stringRomano += "IX";
                break;
        }

        System.out.println(stringRomano);
    }
}
