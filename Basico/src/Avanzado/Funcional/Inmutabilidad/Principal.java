package Avanzado.Funcional.Inmutabilidad;

import java.util.LinkedList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<String> sierEmail = new LinkedList<>();
        sierEmail.add("Sier@gmail.com");

        MutablePerson person = new MutablePerson();
        person.setEmails(sierEmail);
        person.setFirstName("Israel");
        person.setLastName("Sergio");

        //Veamos un poco los peligros
        System.out.println(person);

        System.out.println(person);
    }
}
