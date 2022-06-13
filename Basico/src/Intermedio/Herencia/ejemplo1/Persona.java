package Intermedio.Herencia.ejemplo1;

//Clase Padre
public class Persona {
    String nombre;
    String apellido;
    int edad;
    long DNI;

    public Persona(String nombre, String apellido, int edad, long DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return  "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nEdad: " + edad +
                "\nDNI: " + DNI;
    }
}
