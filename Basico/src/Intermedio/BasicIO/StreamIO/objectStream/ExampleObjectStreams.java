package Intermedio.BasicIO.StreamIO.objectStream;

import java.io.*;

public class ExampleObjectStreams {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String nameFile = "persona.txt";
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new
                    FileOutputStream(nameFile)));
            Object persona = new Persona("Juan","Riquelme",10);
            out.writeObject(persona);
        }catch (WriteAbortedException e){
            System.err.println(e.getMessage());
        }finally {
            out.close();
        }

        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new
                    BufferedInputStream(new FileInputStream(nameFile)));
            Persona persona;
            persona = (Persona) in.readObject();
            System.out.println ("Nombre: " + persona.getNombre() + "\n" +
                                "Apellido: " + persona.getApellido() + "\n" +
                                "Edad: " + persona.getEdad() + "\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
