package Basico;

public class Cast {

    public static void main(String[] args) {
        /*
        Narrowing Casting (manually) - converting a larger type to a smaller size type
        double -> float -> long -> int -> char -> short -> byte

        Widening Casting (automatically) - converting a smaller type to a larger type size
        byte -> short -> char -> int -> long -> float -> double
        */

        //Narrowing Casting
        int numero = 1;
        char numeroChar = (char) numero;
        short numeroShort = (short) numeroChar;
        byte numeroByte = (byte) numeroShort;

        //Widening Casting
        int numeroInt = '/';    //Sacas el numero para tener este caracter ALT + 47 = /
        float numeroFloat =  numeroInt;
        double numeroDouble =  numeroInt;

        System.out.println("Narrowing Casting (larger type to a smaller size type)");
        System.out.println("Int: " + numero);
        System.out.println("Char: " + numeroChar);
        System.out.println("Short: " + numeroShort);
        System.out.println("Byte: " + numeroByte);
        System.out.println("------------------");
        System.out.println("Widening Casting (smaller type to a larger type size)");
        System.out.println("Int: " + numeroInt);
        System.out.println("Float: " + numeroFloat);
        System.out.println("Double: " + numeroDouble);
    }

}
