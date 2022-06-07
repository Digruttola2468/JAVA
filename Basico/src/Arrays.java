public class Arrays {
    public static void main(String[] args) {

        int numeros[] = {1,2,3,4,5,6,7,8,9,10};
        String nombres[] = {"Ivan","Gero","Nico","Mauro","Julian"};

        //Mostrar la posicion en memoria de la variable
        System.out.println(nombres);
        System.out.println(numeros);

        //FORI
        for (int i = 0; i < nombres.length; i++) {
            System.out.print(nombres[i] + " ");
        }
        //FOR-EACH
        for (int x : numeros){
            System.out.print(x + " ");
        }

        //Mostrar una posicion en especifico
        System.out.println("\nNombre: " + nombres[1] + "  Edad: " + numeros[5]);

        //Que pasa si no colocamos todos los datos?
        int[] aux = new int[5];
        aux[0] = 10;
        aux[1] = 20;
        for (int x: aux) {
            System.out.print(x + " ");
        }
    }
}
