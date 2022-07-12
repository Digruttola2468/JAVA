package Avanzado.Funcional.FunctionsPackage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ReferenceOperator {
    public static void main(String[] args) {
        //Obtenemos la lista
        List<String> profesores = getList("Nicolas","Juan","Zulema");

        //Creamos un consumer que por el texto recibido mostrar en pantalla
        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        //------------------------------
        System.out.println();
        System.out.println();
        //------------------------------
        //Existe otra forma de hacerlo

        // :: ve a buscar este metodo definina en este objeto
        profesores.forEach(System.out::println);

        //Recordar: Los metodos tambien son funciones
    }

    //Obtenemos cualquier tipo de elemento y lo pasamos a tipo lista
    static <T> List<T> getList(T... element){
        return Arrays.asList(element);
    }
}
