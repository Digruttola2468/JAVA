package Intermedio.Polimorfismo.ejemplo2;

public class Gato implements Animal{
    @Override
    public void Sound() {
        System.out.println("Miau Miaauu");
    }

    @Override
    public void Run() {
        System.out.println("Gato Corriendo");
    }

    @Override
    public void Attach() {
        System.out.println("Gato Ataca");
    }
}
