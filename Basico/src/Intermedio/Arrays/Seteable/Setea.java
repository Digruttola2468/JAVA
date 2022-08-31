package Intermedio.Arrays.Seteable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Setea {
    public static void main(String[] args) {
        Set<String> nombres = new HashSet<>();

        nombres.add("Ivan");
        nombres.add("Sebastian");
        print(nombres);
        //OUTPUT [Ivan, Sebastian]

        print(nombres.contains("ivan"));
        //OUTPUT FALSE but if it is Ivan return TRUE
        print(nombres.size());
        //OUTPUT 2

        nombres.add("Ivan");
        print(nombres);
        //OUTPUT [Ivan, Sebastian]

        nombres.clear();
        print(nombres.isEmpty());
        //OUTPUT TRUE

    }

    private static void print(Object mens){
        System.out.println(mens);
    }
}
