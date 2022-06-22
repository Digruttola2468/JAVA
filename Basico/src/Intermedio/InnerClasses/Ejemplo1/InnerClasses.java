package Intermedio.InnerClasses.Ejemplo1;


class OuterClass {
    int x = 13;

    class DentroOuter {
        int y = 5;
    }
}

public class InnerClasses {
    public static void main(String[] args) {
        //Obtenemos la x
        OuterClass myOuter = new OuterClass();
        //Obtenemos la Y
        OuterClass.DentroOuter myInner = myOuter.new DentroOuter();
        //Sumamos y mostramos
        System.out.println(myInner.y + myOuter.x);
    }
}