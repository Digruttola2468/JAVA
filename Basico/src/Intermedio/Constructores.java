package Intermedio;

public class Constructores {

    String nombre;
    String apellido;
    int edad;

    Constructores(){
        //Vacio
    }

    Constructores(String nombre,String ape, int edad){
        this.nombre = nombre;
        apellido = ape;
        this.edad = edad;
    }
    Constructores(String nombre,String ape){
        this.nombre = nombre;
        apellido = ape;
    }

    public static void main(String[] args) {
        Constructores con = new Constructores();
        Constructores con2 = new Constructores("Ivan","Digruttola",13);
        Constructores con3 = new Constructores("Mauro","Reta");

        System.out.println(con);
        System.out.println(con2);
        System.out.println(con3);

        System.out.println();
        System.out.println();

        System.out.println("Nombre: " + con.nombre + "\nApellido: " + con.apellido + "\nEdad: " + con.edad);
        System.out.println();
        System.out.println("Nombre: " + con2.nombre + "\nApellido: " + con2.apellido + "\nEdad: " + con2.edad);
        System.out.println();
        System.out.println("Nombre: " + con3.nombre + "\nApellido: " + con3.apellido + "\nEdad: " + con3.edad);

    }

}
