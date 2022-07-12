package Avanzado.Funcional.FunctionsPackage;

public class Chaining {
    public static void main(String[] args) {
        /*Chaining se encarga de encadenar el resultado de una ejection con respecto a otra ejection */

        //Ejemplo
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Hola")
                .append("Ivan")
                .append("Digruttola");
        System.out.println(stringBuilder);

        System.out.println();
        System.out.println();

        //Esto provoca mucha visibilidad
        //Composicion de funciones
        Chainer chainer = new Chainer();
        chainer.sayHi().sayBay();

        System.out.println();
        System.out.println();

        //Tiene la ventaja de no almacenar los resultados
        //Por ejemplo al almacenar los resultados vemos
        Chainer chainer1 = chainer.sayHi();
        Chainer chainer2 = chainer.sayBay();
    }

    static class Chainer {
        public Chainer sayHi(){
            System.out.println("Hola");
            return this;
        }
        public Chainer sayBay(){
            System.out.println("Adios");
            return this;
        }
    }
}
