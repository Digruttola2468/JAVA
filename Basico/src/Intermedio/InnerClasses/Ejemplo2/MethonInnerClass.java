package Intermedio.InnerClasses.Ejemplo2;

class OuterClass {
    int x = 10;

    class InnerClass {
        public int myInnerMethod() {
            return x;
        }
    }
}

class Main {
    public static void main(String[] args) {
        //Obtenemos x
        OuterClass myOuter = new OuterClass();
        //Obtenemos el metodo
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        //Mostramos el metodo
        System.out.println(myInner.myInnerMethod() + myOuter.x);
    }
}
