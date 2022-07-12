package Avanzado.Funcional.FunctionsPackage;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionals {
    /*
    La clase Optional es una manera de almacenar un dato del cual no tenemos certeza cuál es el valor,
    si está o no está presente, y poder acceder a este dato mediante operadores (funciones, consumers, suppliers) que cuando esté presente el dato,
    la clase Optional va a invocar esas funciones pasándoles el dato, en caso contrario (por ejemplo el caso de null) la clase Optional no va a invocar dichas funciones.
    Internamente Optional estará haciendo la lógica para saber cuándo sí y cuándo no ejecutar un pedazo de código.

    Opcional se debe usar para información que se retorna, en lugar de información que se recibe.
    Tu codigo debería usar unicamente Optional como resultado de una función, nunca como entrada.

    Hay varios casos en los que puede llegar a ser útil usar Optional. No en todos los casos es útil usar Optional como valor de retorno.
    https://dzone.com/articles/using-optional-correctly-is-not-optional

    */

    public static void main(String[] args) {
        //Esta es una manera de verificar si es null
        //La desventaja es que tenemos que usar varios if porque tal vez no devuelva un null sino un String vacio
        //Entonces tenemos que agregar otra condicion para ese String vacio
        List<String> names = getNames();
        if(names != null){
        }

        //
        //
        //
        //

        //Y aca aparece Optional , donde colocamos un dato y operar sobre ese dato cuando este o no presente
        //Podemos generar valores por default segun nuestras necesidades en cada interaccion
        Optional< List<String> > optionalNames = getOptionalNames();
        //true if there is a value present, otherwise false
        if(optionalNames.isPresent()){
            System.out.println("SI");
        }

        //
        //
        // Lo mismo de antes pero mas funcional
        //
        //

        //namesValue -> solo va a existir si el valor esta presente
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        //map -> es una funcion a partir de la cual trabajamos con ese dato cuando este presente para convertir en otro dato
        //Previene al encontrarse con datos vacios
        //optionalNames.map()

        Optional<String> valueablePlayer = optionalValueablePlayer();

        //Es una funcion que nos va a generar un nuevo dato , o tenemos un dato o tenemos un dato
        //De esta manera podemos usar Optional para muchas cosas , es una manera
        /*de generar datos sin tener que preocuparse de la */
        String valuablePlayerName = valueablePlayer.orElseGet( () -> "No player");
        System.out.println(valuablePlayerName);
    }

    static List<String> getNames(){
        //Inicializamos la lista y luego la vamos llenando obteniendo de una base de datos por ejemplo
        List<String> list = new LinkedList<>();

        //Obtener datos ...

        //Retornamos la lista de los nombres por ejemplo de una base de datos
        return list;
    }

    //Es buena idea retornar un string o un null si no encontramos un dato ?
    //Las reglas van a variar y van a depender muchisimo de cual sea el caso , incluso hay casos donde un null cobra mucha validez
    //El problema empieza donde si retornamos null tenemos que validar de los datos que recibimos
    //Corroborar que un dato este presente o no este presente
    static String mostValuablePlayer(){
        //return null;
        return "";
    }

    static Optional< List<String> > getOptionalNames(){
        List<String> namesList = new LinkedList<>();

        //Obtencion de nombres...

        //Va a ver un dato presente
        return Optional.of(namesList);

        // of -> Returns an Optional with the specified present non-null value.
        //return Optional.of(null);
    }

    //Pero cuando no tengamos un dato, y lo unico que tenemos es un null ?
    /*Con esto estamos evitando lidiar con nulls*/
    static Optional<String> optionalValueablePlayer(){
        //Le estamos diciendo a opcional tenemos un dato la cual desconocemos si es null o no , nullpointerexception
        //return Optional.ofNullable(null);

        //
        // Pero tal vez no queremos liviar con nulls
        //

        //Con esto estamos liviando trabajar con null
        try{

            //Accesos a nuestros archivos o base de datos
            return Optional.of(new String());
        }catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }


}
