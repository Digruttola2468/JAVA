package Avanzado.Funcional.FunctionsPackage;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionsDemo {

    public static void main(String[] args) {
        //Function<T,R> : Recibe un tipo de dato y genera un nuevo tipo de dato
        Function<Integer,Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        //Como invocar un Function
        System.out.println(square.apply(10));

        //Pero para mostrar de manera mas simple y legible
        //Realizamos una funcion anomina
        //La x es un numero por el Integer, y generamos una validacion
        Function<Integer,Boolean> isOdd = x -> x % 2 == 1;

        System.out.println(isOdd.apply(10)); //False -> Impar

        //Funcion que trabaja sobre un tipo y genera un boolean
        Predicate<Integer> isEven = x -> x % 2 == 0;

        //Revisando si un predicado es verdad
        isEven.test(10);    //True -> Par

        //---------------------------
        //Sirve mucho para corroborar que algo tenga datos
        Predicate<Student> isAprobade = x -> x.getCalificacion() >= 6;
        System.out.println("Alumno aprobado?: " + isAprobade.test(new Student(5.99)));
    }

    static class Student{
        private double calificacion;

        public double getCalificacion() {
            return calificacion;
        }

        public Student(double calificacion) {
            this.calificacion = calificacion;
        }
    }

}
