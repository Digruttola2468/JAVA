package Avanzado.Funcional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamListener {
    public static void main(String[] args) {

        System.out.println("/////////////////////////////");

        //SIN CHAINING
        Stream<String> courseStream = Stream.of("Java","Kotlin","Front-End","Back-End","FullStack","JavaScript","JavaSpring");
        Stream<String> emphasisCourses = courseStream.map(course -> course + "!");
        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println);

        //
        // Chaining es nuestra solucion para no ir almacenando en cada Objeto de Stream
        //

        List<String> list = getList("Java","Kotlin","Front-End","Back-End","FullStack","JavaScript","JavaSpring");

        //CON CHAINING
        Stream<String> courseList = list.stream();

        System.out.println("\n/////////////////////////////\n");

        courseList
                .map(course -> course.toUpperCase())
                .filter(course -> course.length() > 5)
                .forEach(System.out::println);

        System.out.println("\n/////////////////////////////\n");

        Stream<String> courseList2 = list.stream();
        addOperator(
                courseList2.map(course -> course.toUpperCase())
                        .filter(course -> course.length() > 5))
                .forEach(System.out::println);

    }

    static <T> List<T> getList(T... element){
        return Arrays.asList(element);
    }

    /*Es funcion por ejemplo , es muy comun un Stream que va a estar generado en una base de datos
     * Y realizar operaciones de un query a un resultado , despues filtrar los datos , y luego hacer una peticion web
     * Esto ayuda a que sea mas funcional y por ende mas seguro porque no vas a tener lidiar con la presensia o ausensia de datos*/
    static <T> Stream<T> addOperator(Stream<T> stream){
        //Es similar a map, donde recibe un dato y devuelve el mismo dato, asique peek nos ayuda a
        //generar una interaccion de los datos y verlos, sin modificar el Stream
        return stream.peek(data -> System.out.println("Dato: " + data));
    }

}
