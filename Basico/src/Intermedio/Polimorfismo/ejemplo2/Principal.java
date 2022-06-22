package Intermedio.Polimorfismo.ejemplo2;

public class Principal {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();

        gato.Run();
        perro.Sound();
        perro.Attach();
        gato.Run();
    }
}
