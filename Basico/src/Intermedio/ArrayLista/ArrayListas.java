package Intermedio.ArrayLista;

import java.util.ArrayList;

public class ArrayListas {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ivan");
        nombres.add("Sebastian");
        nombres.add("Agustin");
        nombres.add("Marca");
        nombres.add("Tomas");

        System.out.println(nombres);

        ArrayList<Integer> edad = new ArrayList<>();
        edad.add(10);
        edad.add(20);
        edad.add(30);
        edad.add(13);

        System.out.println(edad);

        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ivan","ApellidoIvan",15));
        personas.add(new Persona("Agustin","ApellidoAgustin",12));
        personas.add(new Persona("Marca","ApellidoMarca",16));
        personas.add(new Persona("Tomas","ApellidoTomas",18));

        System.out.println(personas);

        System.out.println();
        System.out.println();

        //Acceder a un objeto
        System.out.println(nombres.get(1));
        System.out.println(edad.get(1));
        System.out.println(personas.get(1));

        System.out.println();
        System.out.println();

        //Cambiar un campo
        nombres.set(1,"Matias");
        edad.set(1,20);
        personas.set(1,new Persona("Fede","ApellidoFede",10));

        System.out.println(nombres.get(1));
        System.out.println(edad.get(1));
        System.out.println(personas.get(1));

        System.out.println();
        System.out.println();

        //Eliminar un item
        nombres.remove(1);
        edad.remove(1);
        personas.remove(1);

        System.out.println(nombres.get(1));
        System.out.println(edad.get(1));
        System.out.println(personas.get(1));

        System.out.println();
        System.out.println();

        //Cantidad de elementos
        System.out.println(nombres.size());
        System.out.println(edad.size());
        System.out.println(personas.size());

        System.out.println();
        System.out.println();

        //Fori
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("[" + i + "]: " + nombres.get(i));
        }

        //for-each
        for (String name : nombres){
            System.out.println(name);
        }

        System.out.println();
        System.out.println();

        //Limpiar todos los campos
        nombres.clear();
        edad.clear();
        personas.clear();

        System.out.println(nombres);
        System.out.println(edad);
        System.out.println(personas);
    }
}
