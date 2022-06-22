package Intermedio.InnerClasses.Ejemplo3;

public class StaticInnerClass {

}
class OuterClass {
    int x = 10;

    static class InnerClass {
        int y = 5;
    }
}

class Main {
    public static void main(String[] args) {
        //Obtenemos y
        OuterClass.InnerClass myInner = new OuterClass.InnerClass();

        System.out.println(myInner.y);
    }
}