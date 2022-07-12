package Avanzado.Funcional.FunctionsPackage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Inferencia {
    public static void main(String[] args) {
        /*
         * En tiempos de compilacion JAVA se encarga de
         * validar los datos que esta pasando en nuestra funcion
         * Adivina basado en la definicion que es el tipo de dato que genera
         * como el que devuelve
         * */
        //Ejemplo de como java al momento de compilar sabe que es un Integer osea int
        Function<Integer,String> funcionConvertidora =
                integer -> "Al doble: " + integer * 2;


        List<String> alumnos = getList("Juan","Hugo","Paco","Luis");

        //Aca le estamos dando el tipo
        alumnos.forEach( (String name) -> System.out.println(name));

        //Gracias a la inferencia de tipos , java al compilar ya sabe que es de tipo String
        alumnos.forEach( name -> System.out.println(name) );

        //Operador de referencia
        //Al realizar el operador de referencia estamos invocando a una funcion que ya sabe que tipo es
        //Java al compilar se encarga de validar si son del mismo tipo
        alumnos.forEach(System.out::println);

    }

    static <T> List<T> getList(T... element){
        return Arrays.asList(element);
    }
}
