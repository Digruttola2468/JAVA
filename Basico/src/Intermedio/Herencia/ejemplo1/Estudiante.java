package Intermedio.Herencia.ejemplo1;

public class Estudiante extends Persona{

    float promedio;
    String escuela;
    int anioEscuela;

    public Estudiante(String nombre, String apellido, int edad, long DNI, float promedio, String escuela, int anioEscuela) {
        super(nombre, apellido, edad, DNI);
        this.promedio = promedio;
        this.escuela = escuela;
        this.anioEscuela = anioEscuela;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nPromedio: " + promedio +
                "\nEscuela: " + escuela +
                "\nAño Escuela: " + anioEscuela;
    }
}
