package Intermedio.BBDD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//CRUD -- Create Read Update Delete
public class PersonaService {

    public static void CrearPersona(){
        Scanner teclado = new Scanner(System.in);

        //Pedimos los datos al usuario
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        //Generalmente despues del nextInt() no hace un salto de linea asique
        teclado.nextLine();

        System.out.print("Fecha Nacimiento [yyyy-MM-dd]: ");
        String fecha = teclado.nextLine();

        System.out.print("Sueldo [0.0]: ");
        Float sueldo = teclado.nextFloat();

        Date fechaDate = StringToDate(fecha);

        if(fechaDate != null){
            Personas personas = new Personas(nombre,apellido,edad,fechaDate,sueldo);
            PersonaBBDD.CreatePersona(personas);
        }else {
            Personas personas = new Personas(nombre,apellido,edad,sueldo);
            PersonaBBDD.CreatePersona(personas);
        }
    }
    public static void ReadPersona(){
        PersonaBBDD.ReadPersonas();
    }
    public static void UpdatePersona(){
        Scanner teclado = new Scanner(System.in);

        System.out.print("ID: ");
        int id = teclado.nextInt();

        teclado.nextLine();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = teclado.nextInt();

        teclado.nextLine();

        System.out.print("Fecha Nacimiento [yyyy-MM-dd]: ");
        String fecha = teclado.nextLine();

        System.out.print("Sueldo [0.0]: ");
        Float sueldo = teclado.nextFloat();

        Date fechaDate = StringToDate(fecha);

        if(fechaDate != null){
            Personas personas = new Personas(id,nombre,apellido,edad,fechaDate,sueldo);
            PersonaBBDD.UpdatePersona(personas);
        }else {
            Personas personas = new Personas(id,nombre,apellido,edad,sueldo);
            PersonaBBDD.UpdatePersona(personas);
        }

    }
    public static void DeletePersona(){
        Scanner teclado = new Scanner(System.in);

        System.out.print("ID persona: ");
        int idPersona = teclado.nextInt();

        PersonaBBDD.DeletePersona(idPersona);

    }

    private static Date StringToDate(String dateString) {
        try {
            Date formatFecha = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            return formatFecha;
        }catch (ParseException e){
            System.err.println(e.getMessage());
            return null;
        }

    }

}
