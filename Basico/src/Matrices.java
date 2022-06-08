public class Matrices {
    public static void main(String[] args) {

        int numeros[][] = {
                {2,4,6,8,10},
                {1,3,5,7,9},
                {10,20,30,40,50},
                {60,70,80,90,100}
        };

        //Mostrar
        System.out.println(numeros);

        for (int i = 0; i < numeros.length; i++) {          //Filas
            for (int j = 0; j < numeros.length; j++) {      //Columnas
                System.out.print("[" + i + "]" + "[" + j + "]: " + numeros[i][j] + "  ");
            }
            System.out.println();
        }

        int numeros2[][] = new int[2][2];
        numeros2[0][0] = 1;
        numeros2[0][1] = 2;
        numeros2[1][0] = 3;
        numeros2[1][1] = 4;

        System.out.println();

        for (int i = 0; i < numeros2.length; i++) {          //Filas
            for (int j = 0; j < numeros2.length; j++) {      //Columnas
                System.out.print("[" + i + "]" + "[" + j + "]: " + numeros2[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
