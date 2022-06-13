package Intermedio.Herencia.ejemplo1;

public class Principal {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Ivan","Di gruttola",19,45638875,100000F,"Torneria");
        Estudiante estudiante = new Estudiante("Sebas","Gutierrez",14,45643235,8,"GOMARA EET",2);

        System.out.println(estudiante);
        System.out.println(empleado);
    }
}
