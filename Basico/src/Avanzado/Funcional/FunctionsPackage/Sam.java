package Avanzado.Funcional.FunctionsPackage;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class Sam {
    public static void main(String[] args) {
        //Si x es menor a 10 , retornar un "0" + x
        //Pero si es falso , 10 == 10 , transforma el int a String
        Function<Integer,String> addCeros = x -> x<10 ? "0" + x: String.valueOf(x);

        //Parseamos la fecha para que retorne un LocalDate
        TriFunctions<Integer,Integer,Integer, LocalDate> parseDate =
                (day,month,year) -> LocalDate.parse(year + "-" + addCeros.apply(month) + "-" + addCeros.apply(day));

        //Hacemos el cálculo de cuantos dias han pasado de hoy hasta la fecha
        TriFunctions<Integer,Integer,Integer,Integer> calculateAge =
                (day,month,year) -> Period.between(
                        parseDate.apply(day,month,year),LocalDate.now()).getYears();

        System.out.println(calculateAge.apply(10,10,1992));

    }

    //Podemos generar nuestros propios tipos de funciones
    //Puedo estar realizando definiciones concretas
    //Single abstract method --> SAM
    @FunctionalInterface
    interface TriFunctions<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
