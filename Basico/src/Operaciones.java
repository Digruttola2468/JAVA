public class Operaciones {

    public static void main(String[] args) {
        float valor1 = 10F;
        float valor2 = 20F;

        float suma = valor1 + valor2;
        float resta = valor1 - valor2;
        float dividir = valor1 / valor2;
        float multiplicar = valor1 * valor2;
        float modulo = valor1 % valor2;//Obtenemos el resto de la división (con esto comprobamos si es par o impar)

        System.out.println(valor1 + " + " + valor2 + " = " + suma);
        System.out.println(valor1 + " - " + valor2 + " = " + resta);
        System.out.println(valor1 + " / " + valor2 + " = " + dividir);
        System.out.println(valor1 + " * " + valor2 + " = " + multiplicar);
        System.out.println(valor1 + " % " + valor2 + " = " + modulo);

    }

}
