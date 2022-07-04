package Intermedio.Arrays.Mapeo;

import java.util.HashMap;
import java.util.Map;

public class MapeoPrincipal {
    public static void main(String[] args) {
        Map<String,String> nombres = new HashMap<>();
        nombres.put("Nombre","Juan");
        nombres.put("Apellido","Riquelme");
        nombres.put("Edad","20");

        System.out.println(nombres);

        System.out.println();
        System.out.println();

        //Obtenemos la variable de la llave especifica
        System.out.println(nombres.get("Nombre"));
        System.out.println(nombres.get("Apellido"));
        System.out.println(nombres.get("Edad"));

        System.out.println();
        System.out.println();

        System.out.println(nombres.values());
        System.out.println(nombres.keySet());
        System.out.println(nombres.size());

        System.out.println();
        System.out.println();

        /*for (int i = 0; i < nombres.keySet().size(); i++) {
            System.out.println(nombres.get(""));
        }*/
        //for-each
        for (String key : nombres.keySet()){
            System.out.println(nombres.get(key));
        }

        System.out.println();
        System.out.println();

        nombres.replace("Nombre","Pedro");
        System.out.println(nombres);

        System.out.println();
        System.out.println();

        nombres.remove("Nombre");
        System.out.println(nombres);

        System.out.println();
        System.out.println();

        nombres.clear();
        System.out.println(nombres);
    }
}
