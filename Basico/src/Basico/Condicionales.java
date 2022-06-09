package Basico;

import java.util.stream.IntStream;


public class Condicionales{
    public static void main(String[] args) {
        int valor1 = 10;
        int valor2 = 20;

        String texto = "Hola";
        String texto2 = "hola";

        //Basico.Condicionales con Tipos Numericos
        // == igual que
        // > mayor que ; >= mayor o igual que
        // < menor que ; <= menor o igual que
        if(valor1 == valor2){
            System.out.println("Son iguales");
        }
        if(valor1 > valor2){
            System.out.println("Valor1 es mayor a valor2");
        }
        if(valor1 < valor2){
            System.out.println("Valor2 es mayor a valor1");
        }
        if(valor1 >= valor2){
            System.out.println("Valor1 es mayor o igual a valor2");
        }
        if(valor1 <= valor2){
            System.out.println("Valor2 es mayor o igual a valor1");
        }

        System.out.println();
        System.out.println();

        //Basico.Condicionales con Tipos String
        if(texto.equals(texto2)){
            System.out.println("Son iguales");
        }else if(texto.length() > texto2.length()){
            System.out.println("Texto1 es mayor al texto2");
        }else if(texto.length() < texto2.length()){
            System.out.println("Texto2 es mayor al texto1");
        }else if(texto.length() == texto2.length()){
            System.out.println("Texto1 tiene igual caracteres Text2");
        }

        if(texto.length() > 5){
            System.out.println("Contiene mas de 5 caracteres");
        }else{
            System.out.println("Contiene menos de 5 caracteres");
        }


        System.out.println();
        System.out.println();


        //Basico.Condicionales
        //      && AND
        //      || OR
        //      !  NOT
        boolean AND =   (10 == 10)  &&  (10>11);    //TRUE y FALSE = FALSE
        boolean OR  =   (10 == 10)  ||  (10>11);    //TRUE o FALSE = TRUE
        boolean NOT =   (10 == 10)  && !(10>11);    //TRUE y TRUE = TRUE

        System.out.println("AND: " + AND);
        System.out.println("OR: " + OR);
        System.out.println("NOT: " + NOT);

        System.out.println();
        System.out.println();

        int rango = (int) (Math.random()*10);
        if(rango <= 10 && rango >= 5){
            System.out.println("Esta en el rango [5-10]: " + rango);
        }else{
            System.out.println("Esta en el rango [0-4]: " + rango);
        }

    }
}