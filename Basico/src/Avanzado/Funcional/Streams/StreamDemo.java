package Avanzado.Funcional.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> courseList = getList("Java","Kotlin","Front-End","Back-End","FullStack");

        //Como podemos hacer operaciones con estos datos?
        for (String course: courseList) {
            String aux = course.toLowerCase().replace("a","1");
            System.out.println("Platzi: " + aux);
        }

        //
        // Como seria en un Stream ??
        //

        //of --> es la manera mas sensilla de generar un Stream
        Stream<String> courseStream = Stream.of("Java","Kotlin","Front-End","Back-End","FullStack","JavaScript","JavaSpring");

        //Un Stream solo puede ser consumido una sola vez
        Stream<String> emphasisCourses = courseStream.map(course -> course + "!");

        //Da error si colocamos el siguiente codigo
        //Stream<String> justJavaCourses = courseStream.filter(course -> course.contains("Java"));

        Stream<String> justJavaCourses = emphasisCourses.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println);
    }

    static <T> List<T> getList(T... element){
        return Arrays.asList(element);
    }
}
