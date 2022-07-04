package Intermedio.Arrays.Interacciones;

import java.util.ArrayList;
import java.util.Iterator;

public class InteratorPrincipal {
    public static void main(String[] args) {
        ArrayList<String> nom = new ArrayList<>();
        nom.add("Pedro");
        nom.add("Tomas");
        nom.add("Lucas");
        nom.add("Sebas");

        Iterator it = nom.iterator();
        while(it.hasNext()){
            String nombre = it.next().toString();
            System.out.println(nombre);
        }
    }
}
