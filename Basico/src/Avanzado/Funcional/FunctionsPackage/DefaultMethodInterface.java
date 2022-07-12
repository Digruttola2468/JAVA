package Avanzado.Funcional.FunctionsPackage;

public class DefaultMethodInterface {
    //Metodos Default en nuestras interfaces
    @FunctionalInterface
    interface StringOperation{
        int getAmount();

        default void operate(String s){
            //Obtenemos el numero
            int x = getAmount();
            while (x-- > 0){
                System.out.println(s);
            }
        }
        //Se puede agregar varios Default method
        default void suma(String x){
            int z = getAmount();
            int y = x.length();

            System.out.println( "Resultado: " + (z + y) );
        }
    }

    @FunctionalInterface
    interface DoOperation {
        void take(String text);

        default void execute(int x,String texto){
            while (x-- > 0){
                take(texto);
            }
        }
    }

    /*
     * Yo podria crear una interfaz donde pueda hacer Query
     * a una base de datos y en la parte default colocar la conexion a
     * dicha base de datos
     * O una conexion a internet
     * */
    public static void main(String[] args) {
        //Envia 6 al getAmount()
        StringOperation six = () -> 6;
        six.operate("Alumno");
        six.suma("Ivan");

        //Envia el texto al take(String text);
        DoOperation operation = text -> System.out.println(text + " Di Gruttola");
        operation.execute(5,"Ivan");
    }
}
