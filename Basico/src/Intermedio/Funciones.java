package Intermedio;

public class Funciones {

    //void --> vacio
    public void mostrar(){
        System.out.println("Mostrar");
    }
    public void mostrar(String texto){
        System.out.println(texto);
    }

    //Return
    public int suma(int x,int y){
        return x + y;
    }
    public float suma(float x,float y){
        return x + y;
    }
    public boolean isEquals(String texto,String otherText){
        return texto.equals(otherText);
    }

    //static
    public static double suma (double x, double y) {
        return x + y;
    }
    //final
    public final String texto (){
        return "Texto";
    }

    /*¿Cuándo usar método static en Java?
        La directiva static permite el acceso a métodos y variables de clase
        sin la necesidad de instanciar un objeto de dicha clase,
        permitiendo la inicialización de forma cómoda y durante la carga de clase
    */

    /*¿Cuándo usar método final en Java?
    *  El método no puede ser sobreEscrito (overridden), esto pasa en la herencia
    * */

    public static void main(String[] args){
        Funciones fun = new Funciones();

        fun.mostrar();
        fun.mostrar("Texto");
        System.out.println(fun.suma(10,10));
        System.out.println(fun.isEquals("ivan","Ivan"));
        System.out.println(suma(10.0,20.6));
        System.out.println(fun.texto());
    }

}
