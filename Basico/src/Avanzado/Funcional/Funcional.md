# Programacion Funcional en Java SE
La programacion funcional es un paradigma de programacion (Es una forma de programar , un estilo)
La programacion funcional es mucho mas que Lambdas.
Hay lenguajes que al no ser 100% funcionales te ayudan de manera indirecta a saber usalo ej(JavaScrip, Kotlin)
Se enfoqua en que resolver el problema sin importar su procedencia.

- Legibilidad 
- Testing
- Concurrencia
- Comportamiento mas definidos
- Menos manejo de estados
- No hay que instalar nada adicional

### Que es una funcion?
Es un tipo de dato que toma un valor X y genera un valor Y.
- Serie de pasos parametrizados
- Puede o no Devolver un resultado
- Se puede definir, almacenar o declarar bajo demanda

Podemos definir funciones con respecto a si mismas (recursividad)
Podemos definir funciones que tomen otras funciones como parametros

# Cuidadanos de primera clase
Ahora podemos tomarlos como parametros o retornos y definirlos bajo demanda

### Funciones Puras
Es una funcion que siempre genera el mismo resultado, no tiene ninguna dependencia con una base de datos por ejemplo.
Funcionan en aislamiento (no dependen ni las afecta un contexto)

Ejemplo:
`boolean has availableFound(double balance){ return balance > 0.0 }`

Las funciones que no son puras son **funciones inpuras** que no sabemos predecir que nos devolvera como resultado.
Por ende una funcion pura puede invocar a una pura pero NO a una impura.
Pero las funciones impuras puede invocar puras e impuras


# Efectos Secundarios
Las funciones impuras generan efectos secundarios
Es todo cambio observable desde fuera del sistema
Son necesarios pero podemos reducir/controlar cuando suceden.

La principal idea es tener codigo estructurado, donde al obtener una entrada de datos, usar esos mismos datos para 
controlar dentro del programa.

# Funcion de orden mayor
Es funcion de orden mayor si Cumple al menos una de estas dos caracteristicas: 
- Toma otra funcion como parametro --> `int foo(Function param)`
- Retorna una funcion como resultado --> `Function bar(int x)`
- O ambas `Function bax(Function f)`

**Ventajas**
- Pasar comportamiento
- Compartir un medio de comunicacion (callbacks --> Cuando tengas un dato pasamelo a esta funcion )
- Compartir logica/reglas

# Funciones Lambda
Parten de un concepto matematico por _Alonzo Church_  <br>
**Funcion**: Tiene un nombre <br>
**Lambda**: No tiene nombre por ende son funciones anonimas , pero sigue siendo un funcion

**Para que usarlas ?**
- Es un comportamiento de uso unico
- Una regla que solo se requiere en un lugar
- Es una funcion extremadamente simple

# Inmutabilidad
**Ventajas**
- Una vez creado no se puede alterar
- Facilita crear funciones puras
- Facilita usar Threads/Concurrencia

**Desventajas**
- Nueva Instancia por cada set de modificaciones
- Requiere especial atencion al diseño
- Objeto mutables fuera de nuestro alcance

La palabra de encapsulamiento `final` en Java poco tiene que ver con mutabilidad.
Marcar como `final` un nombre (miembro de clase o variable local) hace que dicho nombre sea read-only una vez el mismo es instanciado.

```
final myVar = new ArrayList<String>();
myVar = Collections.emptyList(); // Incurre en un error porque myVar es de solo lectura (no se puede re-asignar)
```

Pero nada evita mutar el objeto referenciado por un nombre marcado como final

```
final myVar = new ArrayList<String>();
myVar.add("Hello");
```
Para evitar la mutación, además de usar nombres marcados como final, hay que usar tipos de datos inmutables (ArrayList no es uno de ellos), 
evitar la herencia donde es posible y respetar el principio de **sustitución de Liskov** cuando no lo es.

[Repositorio del curso](https://github.com/sierisimo/JavaSE-Functional-platzi/branches/active?page=1)


- **Consumer**<T>: recibe un dato de tipo T y no genera ningún resultado
- **Function**<T,R>: toma un dato de tipo T y genera un resultado de tipo R
- **Predicate**<T>: toma un dato de tipo T y evalúa si el dato cumple una condición
- **Supplier**<T>: no recibe ningún dato, pero genera un dato de tipo T cada vez que es invocado
- **UnaryOperator**<T> recibe un dato de tipo T y genera un resultado de tipo T

Estas interfaces (y otras más) sirven como la base de donde generar los objetos con las lambdas que pasamos a los diferentes métodos de Stream.
Cada una de ellas cumple esencialmente con recibir el tipo de dato de el Stream y generar el tipo de retorno que el método espera.

Si tuvieras tu propia implementación de Stream, se vería similar al siguiente ejemplo:
```Java
public class PlatziStream<T> implements Stream {
    private List<T> data;

    public Stream<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new LinkedList<>();
        for(T t : data){
            if(predicate.test(t)){
                filteredData.add(t);
            }
        }

        return filteredData.stream();
    }
}
```

Probablemente, tendría otros métodos y estructuras de datos, pero la parte que importa es justamente cómo se usa el Predicate.
Lo que hace Stream internamente es pasar cada dato por este objeto que nosotros proveemos como una lambda y,
según el resultado de la operación, decidir si debe incluirse o no en el Stream resultante.

# Operaciones
A estas funciones que reciben lambdas y se encargan de trabajar (operar) sobre los datos de un Stream generalmente se les conoce como Operaciones.

Existen dos tipos de operaciones: **intermedias** y **finales**.

Aunque son métodos, se les considera operaciones, puesto que su intención es operar el Stream y, 
posterior a su trabajo, el Stream no puede volver a ser operado.

# Collectors
Una vez que has agregado operaciones a tu Stream de datos, 
lo más usual es que llegues a un punto donde ya no puedas trabajar con un Stream y necesites enviar tus datos en otro formato, por ejemplo, JSON o una List a base de datos.

Existe una interfaz única que combina todas las interfaces antes mencionadas y que tiene como única utilidad proveer de una operación para obtener todos los elementos de un Stream: Collector.

Collector<T, A, R> es una interfaz que tomará datos de tipo T del Stream, un tipo de dato mutable A, donde se iran agregando los elementos (mutable implica que podemos cambiar su contenido, como un LinkedList), y generara un resultado de tipo R.
Suena complicado… y lo es. Por eso mismo, Java 8 incluye una serie de Collectors ya definidos para no rompernos las cabeza con cómo convertir nuestros datos.

```Java
public class Ejemplo{
    public List<String> getJavaCourses(Stream<String> coursesStream) {
        List<String> javaCourses =
            coursesStream.filter(course -> course.contains("Java"))
                    .collect(Collectors.toList());

        return javaCourses;
    }
}
```
Usando java.util.stream.Collectors podemos convertir muy sencillamente un Stream en un Set, Map, List, Collection, etc.
La clase Collectors ya cuenta con métodos para generar un Collector que corresponda con el tipo de dato que tu Stream está usando.
Incluso vale la pena resaltar que Collectors puede generar un ConcurrentMap que puede ser de utilidad si requieres de multiples threads.

Usar Collectors.toXXX es el proceso inverso de usar Collection.stream().
Esto hace que sea fácil generar APIs publicas que trabajen con estructuras/colecciones comunes e internamente utilizar Stream para agilizar las operaciones de nuestro lado.

# Tipos de retorno
Hasta este punto, la única manera de obtener un dato que ya no sea un Stream es usando Collectors,
pues la mayoría de operaciones de Stream se enfocan en operar los datos del Stream y generar un nuevo Stream con los resultados de la operación.

Sin embargo, algunas operaciones no cuentan con un retorno.
Por ejemplo, forEach, que es una operación que no genera ningún dato.
Para poder entender qué hace cada operación basta con plantear qué hace la operación para poder entender qué puede o no retornar.

#Operaciones Terminales
Las operaciones terminales son aquellas operaciones que como resultado no generan un nuevo Stream. Su resultado puede variar según la operación. La utilidad de estas es poder generar un valor final a todas nuestras operaciones o consumir los datos finales. La razón principal para querer esto es que los datos deberán salir en algún punto de nuestro control.
por ejemplo, en un servidor web. Recibe una petición de datos, convierte la petición en un Stream, procesa los datos usando filter o map, convierte de JSON a datos locales que sean manipulables por código Java y hace consumo de una base de datos. Todo esto mediante streams de diferentes tipos. Pero eventualmente tiene que devolver una respuesta para quien le hizo la petición.

¿Qué pasa si quien hizo la petición no esta usando Java? No podemos enviarle un objeto de tipo Stream a un código hecho en Python o en JavaScript… es ahi donde una operación final nos ayuda a convertir nuestro Stream de Java en algún tipo de dato que sea mas comprensible.

Es por ello que quisiéramos proveer de algo mas simple: listas, primitivos o incluso dar algún mecanismo para poder usar código externo de nuestro lado.

Las operaciones terminales más comunes que se encuentran en Stream son:

- anyMatch()
- allMatch()
- noneMatch()
- findAny()
- findFirst()
- min()
- max()
- reduce()
- count()
- toArray()
- collect()
- forEach()
Revisaremos qué hacen y qué utilidad tienen durante esta lectura.

#### Operaciones Termnales de Coincidencia
**anyMatch, allMatch, noneMatch**
Las operaciones anyMatch, allMatch y noneMatch sirven para determinar si en un Stream hay elementos que cumplan con un cierto Predicate. Esto puede ser una forma simple de validar los datos de un Stream.
Son terminales pues las tres retornan un boolean

```
//Nos indica si un stream contiene un elemento según el Predicate que le pasemos:
Stream numbersStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 11);
boolean biggerThanTen = numbersStream.anyMatch(i -> i > 10); //true porque tenemos el 11

//allMatch
//Nos indica si todos los elementos de un Stream cumplen con un cierto Predicate:
Stream agesStream = Stream.of(19, 21, 35, 45, 12);
boolean allLegalDrinkingAge = agesStream.allMatch(age -> age > 18); //false, tenemos un menor

//noneMatch
//Nos indica si todos los elementos de un Stream NO CUMPLEN un cierto Predicate:
Stream oddNumbers = Stream.of(1, 3, 5, 7, 9, 11);
boolean allAreOdd = oddNumbers.noneMatch(i -> i % 2 == 0);
```

#### Operaciones terminales de Busqueda
**findAny, findFirst**
Estas operaciones retornan un Optional como resultado de buscar un elemento dentro del Stream.

La diferencia entre ambas es que findFirst retornara un Optional conteniendo el primer elemento en el Stream si el Stream tiene definida previamente una operación de ordenamiento o para encontrar elementos. De lo contrario, funcionará igual que findAny, tratando de devolver cualquier elemento presente en el Stream de forma no determinista (random)
Si el elemento encontrado es null, tendrás que lidiar con una molesta NullPointerException. Si el Stream esta vacío, el retorno es equivalente a Optional.empty().
La principal razón para usar estas operaciones es poder usar los elementos de un Stream después haber filtrado y convertido tipos de datos. Con Optional nos aseguramos que, aún si no hubiera resultados, podremos seguir trabajando sin excepciones o escribiendo condicionales para validar los datos.

#### Operaciones terminales de reduccion
**min, max**
Son dos operaciones cuya finalidad es obtener el elemento más pequeño (min) o el elemento más grande (max) de un Stream usando un Comparator. Puede haber casos de Stream vacíos, es por ello que las dos operaciones retornan un Optional para en esos casos poder usar Optional.empty.

```
Stream bigNumbers = Stream.of(100L, 200L, 1000L, 5L);
Optional minimumOptional = bigNumbers.min((numberX, numberY) -> (int) Math.min(numberX, numberY));
```

**reduce**

- reduce(valorInicial, BinaryOperator)
- reduce(BinaryAccumulator)
- reduce(valorInicial, BinaryFunction, BinaryOperator)

**reduce(BinaryAccumulator)**
Retorna un Optional del mismo tipo que el Stream, con un solo valor resultante de aplicar el BinaryAccumulator sobre cada elemento o Optional.empty() si el stream estaba vacío. Puede generar un NullPointerException en casos donde el resultado de BinaryAccumulator sea null.

```
Stream aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
Optional longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."
```

**reduce(valorInicial, BinaryOperator)**
Retorna un valor del mismo tipo que el Stream después de aplicar BinaryOperator sobre cada elemento del Stream. En caso de un Stream vacío, el valorInicial es retornado.

```
Stream firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum); //45 -> 0 + 1 + … + 9
```

**reduce(valorInicial, BinaryFunction, BinaryOperator)**
Genera un valor de tipo V después de aplicar BinaryFunction sobre cada elemento de tipo T en el Stream y obtener un resultado V.

Esta version de reduce usa el BinaryFunction como map + reduce. Es decir, por cada elemento en el Stream se genera un valor V basado en el valorInicial y el resultado anterior de la BinaryFunction. BinaryOperator se utiliza en streams paralelos (stream.parallel()) para determinar el valor que se debe mantener en cada iteración.

```
Stream aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.length(), Integer::sum);
```

**count**
sirve para obtener cuantos elementos hay en el Stream.

```
Stream yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020);
long yearsCount = yearsStream.count(); //7, solo nos dice cuantos datos tuvo el stream.
```
La principal razón de usar esta operación es que, al aplicar filter o flatMap, nuestro Stream puede crecer o disminuir de tamaño y, tal vez, de muchas operaciones solo nos interese saber cuántos elementos quedaron presentes en el Stream. Por ejemplo, cuantos archivos se borraron o cuantos se crearon por ejemplo.

**toArray**
Agrega todos los elementos del Stream a un arreglo y nos retorna dicho arreglo. La operación genera un Object[], pero es posible hacer castings al tipo de dato del Stream.

**collect**
Mencionamos la operación collect en la lectura sobre operaciones y collectors, donde mencionamos que:
Collector es una interfaz que tomara datos de tipo T del Stream, un tipo de dato mutable A, donde se irán agregando los elementos (mutable implica que podemos cambiar su contenido, como un LinkedList) y generara un resultado de tipo R.
Usando java.util.stream.Collectors podemos convertir sencillamente un Stream en un Set, Map, List, Collection, etc.

```
public List getJavaCourses(Stream coursesStream) {
    List javaCourses =
        coursesStream.filter(course -> course.contains("Java"))
            .collect(Collectors.toList());

    return javaCourses;
}
```

**Operaciones terminales de iteración**
**forEach**
forEach es una operación que recibe un Consumer y no tiene un valor de retorno (void). La principal utilidad de esta operación es dar un uso final a los elementos del Stream.

```
Stream> courses = getCourses();
courses.forEach(courseList -> System.out.println("Cursos disponibles: " + courseList));
```

Internamente, al recibir una operación, el Stream en algún punto llama a su método close, que se encarga de liberar los datos y la memoria del Stream.


# Operaciones Intermedias
Toda operación dentro de un Stream que como resultado devuelva un nuevo Stream.
tras invocar una operación intermedia con un cierto tipo de dato, obtendremos como resultado un nuevo Stream conteniendo los datos ya modificados.

```
Stream initialCourses = Stream.of("Java", "Spring", "Node.js");

Stream lettersOnCourses = initialCourses.map(course -> course.length());
//De este punto en adelante, initialCourses ya no puede agregar mas operaciones.

Stream evenLengthCourses = lettersOnCourses.filter(courseLength -> courseLength % 2 == 0);
//lettersOnCourses se consume en este punto y ya no puede agregar mas operaciones. No es posible usar el Stream mas que como referencia.
```

## Operaciones Disponibles
- filter(…)
- map(…)
- distinct(…)
- limit(…)
- peek(…)
- skip(…)
- sorted(…)

**filter**
```
public Stream getJavaCourses(List courses){
    return courses.stream()
        .filter(course -> course.contains("Java"));
}
```
filter se encarga de iterar cada elemento del Stream y evaluar con el Predicate si el elemento debe estar o no en el Stream resultante. Si nuestro Predicate es sencillo y no incluye ningún ciclo o llamadas a otras funciones que puedan tener ciclos, la complejidad del tiempo es de O(n), lo cual hace que el filtrado sea bastante rápido.

Usos comunes de filter es limpiar un Stream de datos que no cumplan un cierto criterio. Como ejemplo podrías pensar en un Stream de transacciones bancarias, mantener el Stream solo aquellas que superen un cierto monto para mandarlas a auditoria, de un grupo de calificaciones de alumnos filtrar únicamente por aquellos que aprobaron con una calificación superior a 6, de un grupo de objetos JSON conservar aquellos que tengan una propiedad en especifico, etc.

Entre mas sencilla sea la condición de filtrado, más legible sera el código. Te recomiendo que, si tienes más de una condición de filtrado, no le temas a usar varias veces filter:
```
courses.filter(course -> course.getName().contains("Java"))
    .filter(course -> course.getDuration() > 2.5)
    .filter(course -> course.getInstructor().getName() == Instructors.SINUHE_JAIME)
```
Tu código sera más legible y las razones de por qué estás aplicando cada filtro tendrán más sentido.

**map**
La operación es meramente una transformación de un tipo a otro.
son muy similares a los de filter, pero la diferencia clave está en T y R. Estos generics nos dicen que map va a tomar un tipo de dato T, cualquiera que sea, le aplicara la función mapper y generara un R.
map operará sobre cada elemento en el Stream inicial aplicando la Function que le pases como lambda para generar un nuevo elemento y hacerlo parte del Stream resultante:
```
Stream ids = DatabaseUtils.getIds().stream();

Stream users = ids.map(id -> db.getUserWithId(id));
```

**distinct**
Lo que hace es comparar cada elemento del Stream contra el resto usando el método equals. De esta manera, evita que el Stream contenga elementos duplicados. La operación, al ser intermedia, retorna un nuevo Stream donde los elementos son únicos. Recuerda que para garantizar esto es recomendable que sobrescribas el método equals en tus clases que representen datos.

**limit**
La operación limit recibe un long que determina cuántos elementos del Stream original seran preservados. Si el número es mayor a la cantidad inicial de elementos en el Stream, básicamente, todos los elementos seguirán en el Stream. Un detalle interesante es que algunas implementaciones de Stream pueden estar ordenadas (sorted()) o explícitamente no ordenadas (unordered()), lo que puede cambiar drásticamente el resultado de la operación y el performance.

**peek**
peek funciona como una lupa, como un momento de observación de lo que está pasando en el Stream. Lo que hace esta operación es tomar un Consumer, pasar los datos conforme van estando presentes en el Stream y generar un nuevo Stream idéntico para poder seguir operando.
```
Stream serverConnections =
    server.getConnectionsStream()
        .peek(connection -> logConnection(connection, new Date()))
        .filter(…)
        .map(…)
    //Otras operaciones…
```

**skip**
Esta operación es contraria a limit(). Mientras limit() reduce los elementos presentes en el Stream a un numero especifico, skip descarta los primeros n elementos y genera un Stream con los elementos restantes en el Stream.
```
Stream first10Numbers = Stream.of(0,1,2,3,4,5,6,7,8,9);
Stream last7Numbers = first10Numbers.skip(3); // 3,4,5,6,7,8,9
```
Esto puede ser de utilidad si sabemos qué parte de la información puede ser descartable. Por ejemplo, descartar la primera línea de un XML (), descartar metadatos de una foto, usuarios de prueba al inicio de una base de datos, el intro de un video, etc.

**sorted**
La operación sorted() requiere que los elementos presentes en el Stream implementen la interfaz Comparable para poder hacer un ordenamiento de manera natural dentro del Stream. El Stream resultante contiene todos los elementos pero ya ordenados, hacer un ordenamiento tiene muchas ventajas



