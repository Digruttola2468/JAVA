package Intermedio.Polimorfismo.Ejemplo4;

public class Principal {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();

        gato.sound();
        perro.sound();
    }
}
abstract class Animal {
    public abstract void sound();
}

class Gato extends Animal {

    @Override
    public void sound() {
        System.out.println("Miau");
    }
}

class Perro extends Animal {

    @Override
    public void sound() {
        System.out.println("Wowf");
    }
}
