package Intermedio.Enum;

public enum Altura {
    LOW,MEDIUM,HIGH
}

class Principal{

    public static void main(String[] args) {
        //Ejemplo 1
        System.out.println("Bajo: " + Altura.LOW);
        System.out.println("Medio: " + Altura.MEDIUM);
        System.out.println("Alto: " + Altura.HIGH);

        //Ejemplo 2
        Altura altura = Altura.HIGH;
        System.out.println(altura);

        //Ejemplo switch
        Altura myVar = Altura.MEDIUM;
        switch(myVar) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }

        //Ejemplo for-each
        for (Altura altu : Altura.values()) {
            System.out.println(altu);
        }
    }
}