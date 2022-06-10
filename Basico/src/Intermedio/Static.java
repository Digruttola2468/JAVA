package Intermedio;

class Static {
    Static(){}

    //*Variable static
    int x;          //Variable de instancia normal
    static int y;   //Variable estática
    //Retornar la suma de la variable de instancia 'x'
    //y la variable estática 'y'
    int suma(){
        return x+y;
    }


    //*Metodo static
    //int valor = 2; //Error: Non-static field 'valor' cannot be referenced from a static context
    //static int valor = 2; //Correcto
    /*el método estático se llama a través de su nombre de clase, sin que se cree ningún objeto de esa clase*/
    static int valDiv2(){
        return y/2;
    }

    //*Bloque statico
    /*Un bloque estático se ejecuta cuando la clase se carga por primera vez.
     Por lo tanto, se ejecuta antes de que la clase se pueda usar para cualquier otro propósito*/
    /*Por ejemplo, podría necesitar establecer una conexión a un sitio remoto*/
    static double raizDe2;
    static double raizDe3;
    static {
        System.out.println("Dentro del bloque estático.");
        raizDe2=Math.sqrt(2.0);
        raizDe3=Math.sqrt(3.0);
    }
    Static (String mens) {
        System.out.println(mens);
    }
}
class Test{
    public static void main(String[] args) {
        System.out.println("---Variable Static---\n");
        Static ob1=new Static();
        Static ob2=new Static();
        //Cada objeto tiene su propia copia de una variable de instancia
        ob1.x=10;
        ob2.x=12;
        System.out.println("Por supuesto, ob1.x y ob2.x son independientes.");
        System.out.println("ob1.x: " + ob1.x + "\nob2.x: " + ob2.x);
        System.out.println();
        //Cada objeto comparte una copia de una variable estática
        System.out.println("La variable estática 'y' es compartida.\n");
        Static.y=100;

        System.out.println("ob1.suma(): " + ob1.suma());  //10 + 100 = 110
        System.out.println("ob2.suma(): " + ob2.suma());  //12 + 100 = 120

        System.out.println();
        System.out.println();
        System.out.println();

        //y = 100
        System.out.println("---Metodo static---");
        System.out.println("El valor es: "+Static.y);
        System.out.println("StaticDemo.valDiv2(): " + Static.valDiv2());
        Static.y=4;
        System.out.println("El valor es: "+Static.y);
        System.out.println("StaticDemo.valDiv2(): " + Static.valDiv2());

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("---Bloques estáticos---");
        System.out.println("La raíz cuadrada de dos es: " + Static.raizDe2);
        System.out.println("La raíz cuadrada de tres es: " + Static.raizDe3);
    }
}