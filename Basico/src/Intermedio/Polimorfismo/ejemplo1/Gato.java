package Intermedio.Polimorfismo.ejemplo1;

public class Gato extends Animal{

    public Gato(String nombre, String raza, int edad) {
        super(nombre, raza, edad);
    }

    @Override
    void sonido() {
        System.out.println("Miau Miau");
    }

}
