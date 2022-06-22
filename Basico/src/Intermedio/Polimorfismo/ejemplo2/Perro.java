package Intermedio.Polimorfismo.ejemplo2;

public class Perro implements Animal{
    @Override
    public void Sound() {
        System.out.println("Wow Woow Wowf");
    }

    @Override
    public void Run() {
        System.out.println("Perro corriendo");
    }

    @Override
    public void Attach() {
        System.out.println("Perro Ataca");
    }
}
