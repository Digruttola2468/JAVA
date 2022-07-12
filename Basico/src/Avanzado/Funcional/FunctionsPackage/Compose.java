package Avanzado.Funcional.FunctionsPackage;

import java.util.function.Function;

public class Compose {
    public static void main(String[] args) {

        Function<Integer, Integer> multiplyBy3 = x -> {
            System.out.println("Multiplicacion x: " + x + " por 3");
            return x * 3;
        };

        //Primero se ejecuta la lambda y luego el multiplyBy3
        Function<Integer, Integer> addMultiplyBy3 =
                multiplyBy3.compose(y -> {
                    System.out.println("Le agregare 1 a " + y);
                    return y + 1;
                });

        //-----------------------------------------------------------------------------------------------

        //Se ejecuta el addMultiplyBy3, cuando llega a la Function se ejecuta el compose primero
        //Luego se ejecuta el multiplyBy3 y luego el andSquare
        Function<Integer,Integer> andSquare =
                addMultiplyBy3.andThen( x -> {
                    System.out.println("Estoy elevando " + x + " al cuadrado");
                    return x * x;
                });

        System.out.println(
                addMultiplyBy3.apply(5)
        );

        System.out.println(
                andSquare.apply(3)
        );

        /*Compose
         * Toma una funcion , ejecuta esa funcion primero
         * Y despues ejecuta la funcion sobre la cual la mando a llamar
         * */
    }
}
