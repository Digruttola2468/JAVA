package Avanzado.Funcional.Streams;

import java.util.stream.IntStream;

public class HilosStream {
    public static void main(String[] args) {

        //Cuando usamos el metodo parallel
        /*Stream se va a encargar de distribuir los datos en
         * los nucleos de tu procesador , si tu computadora tiene un
         * procesador con 4 nucleos, enconteses va a distribuir los datos
         * en esos 4 nucleos*/
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        infiniteStream.limit(1000)
                .parallel()             //Lo hace de una manera concurrente
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        //Pero tiene un condicion
        //Si tengo pocos datos Stream trabaja mejor sobre un solo nucleo del procesador
        //Si tienes muchos datos o millones , es recomendable usar parallel() a no ser que el orden te importara

    }
}
