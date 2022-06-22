package Intermedio.Polimorfismo.ejemplo1;

public class Perro extends Animal{
    public Perro(String nombre, String raza, int edad) {
        super(nombre, raza, edad);
    }

    @Override
    void sonido() {
        System.out.println("Wowf Wow");
    }


}
