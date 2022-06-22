package Intermedio.Polimorfismo.ejemplo1;

public class Principal {

    public static void main(String[] args) {
        Perro perro = new Perro("Layca","Obejero",2);
        Gato gato = new Gato("Chompita","Tuvijea",5);

        System.out.println(
                "Animal: " + "Perro" + "\n" +
                "Nombre: " + perro.getNombre() + "\n" +
                "Raza: " + perro.getRaza() + "\n" +
                "Edad: " + perro.getEdad());
        perro.sonido();

        System.out.println(
                "Animal: " + "Gato" + "\n" +
                "Nombre: " + gato.getNombre() + "\n" +
                "Raza: " + gato.getRaza() + "\n" +
                "Edad: " + gato.getEdad());
        gato.sonido();
    }
}
