package Avanzado.Funcional.FunctionsPackage;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class FunctionsDemo2 {
    public static void main(String[] args) {
        //Es una funcion que trabaja sobre un tipo definido
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!!!";

        System.out.println(quote.apply("Hola"));
        System.out.println(addMark.apply("Cuidado"));

        //-------------------------------------------------------------------------------------
        //Trabaja sobre 2 Tipos y genera el valor del tipo especificado
        BiFunction<String,Integer,String> leftPad =
                (text,number) -> String.format("%" + number + "s",text); //Formate

        System.out.println(leftPad.apply("Java",10));

        BiFunction<Integer,Integer,Integer> multiplicacion =
                (x,y) -> x * y;

        System.out.println(multiplicacion.apply(10,2));

        //-------------------------------------------------------------------------------------
        //Esto es lo mismo que decir, cuando se repiten los tipos
        BinaryOperator<Integer> multiplicacionBi =
                (x,y) -> x * y;

        System.out.println(multiplicacionBi.apply(10,2));

        //SAM -> Single Abstract Method
        //Interfaz que tiene un solo methodo sin definir
    }
}
