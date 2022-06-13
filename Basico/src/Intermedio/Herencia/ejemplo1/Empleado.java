package Intermedio.Herencia.ejemplo1;

//Clase Hija
public class Empleado extends Persona {

    Float sueldo;
    String puestoTrabajo;

    public Empleado(String nombre, String apellido, int edad, long DNI, Float sueldo, String puestoTrabajo) {
        super(nombre, apellido, edad, DNI);
        this.sueldo = sueldo;
        this.puestoTrabajo = puestoTrabajo;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nSueldo: " + sueldo +
                "\nPuestoTrabajo: " + puestoTrabajo;
    }
}
