package Basico;

public class Bucles {
    
    public static void main(String[] args) {
        
        //Bucle while
        int i = 1; 
        while(i<=5){
            System.out.println(i);
            i++;
        }

        //Bucle infinito while
        /*while (true){
            System.out.println("HOLA");
        }*/

        //Bucle for
        for(int j=0 ; j<5 ; j++){
            System.out.println(j);
        }

        //Bucle infinito for
        /*for (;;){
            System.out.println("HOLA");
        }*/

        //Bucle Do-While
        i = 0;
        do{
            System.out.println(i);
            i++;
        }while(i<=5);


        //FOR-EACH
        String array[] = {"Ron", "Harry", "Hermoine"};
        for (String x : array)
        {
            System.out.println(x);
        }

        /*bucle for para la misma función
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        */

    }

}