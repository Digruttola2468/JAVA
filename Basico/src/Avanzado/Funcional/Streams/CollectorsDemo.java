package Avanzado.Funcional.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsDemo {
    public static void main(String[] args) {
        IntStream infiniteStream = IntStream.iterate(0, x -> x + 1);
        List<Integer> numeros = infiniteStream.limit(1000)
                .filter(x -> x % 2 == 0)
                .boxed()    //Convertimos a otro tipo de Stream, a un Stream<Integer>
                .collect(Collectors.toList());  //Obtenemos una lista de los elementos

        System.out.println(numeros);
    }
}
