package Avanzado.Funcional.FunctionsPackage;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SintaxisLambdas {
    public static void main(String[] args) {
        List<String> cursos = getList("Java","Funcional");

        //Sabemos que es una lambda porque no esta almacenada en nunguna parte del codigo
        //Son casos unicos
        cursos.forEach(curso -> System.out.println(curso));

        //Tenemos Lambdas que no recibe ningun dato
        int numero = 2;
        usarZero( () -> numero);
        usarZero( () -> 2);

        //Lambdas que recibe un dato
        userPredicado(text -> text.isEmpty());

        //Recibe dos tipos de datos
        usarBiFunction( (x,y) -> x * y);

        //
        usarBiFunction( (x,y) -> {
            System.out.println("X: " + x + " , Y: " + y);
            return x * y;
        });

        //Sintaxis para entender a una funcion que no recibe ninguna funcion y no devuelve ningun dato
        usarNada( () -> {
            System.out.println("Hola No Devuelvo nada");
        } );

        //Las funciones trabajan sobre objetos, asique no podemos usar datos primitivos
        //usarBiFunction( (int x,int y) -> x * y);
        usarBiFunction( (Integer x, Integer y) -> x * y);
    }

    static void usarZero(ZeroArgumentos zeroArgumentos){
        zeroArgumentos.get();
    }

    static void userPredicado(Predicate<String> predicate){
        predicate.test("Prueba");
    }

    static void usarBiFunction(BiFunction<Integer,Integer,Integer> biFunction){
        biFunction.apply(10,20);
    }

    static void usarNada(Nada nada){
        nada.nada();
    }

    @FunctionalInterface
    interface Nada{
        void nada();
    }

    @FunctionalInterface
    interface ZeroArgumentos {
        int get();
    }

    static <T> List<T> getList(T... element){
        return Arrays.asList(element);
    }
}
