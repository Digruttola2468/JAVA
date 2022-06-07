
public class OperacionesMath {

    public static void main(String[] args) {

        double valor1 = 10F;
        int numero = 10;
        int numero2 = -10;
        double valor2 = -10F;

        double PI = Math.PI;
        double E = Math.E;
        System.out.println("PI: " + PI);
        System.out.println("e: " + E);

        double potencia = Math.pow(2,valor1);                   //Potencia
        double raiz = Math.sqrt(valor1);                        //Root
        int numeroRandom = (int) (Math.random() * valor1);      //Random
        double numeroAbsoluto = Math.abs(valor2);               //Absolute number
        double coseno = Math.cos(valor1);                       //Coseno
        double seno = Math.sin(valor1);                         //Seno
        double tangente = Math.tan(valor1);                     //Tangente
        double hypot = Math.hypot(valor1,valor2);               //Returns sqrt(x2 +y2)
        double logaritmoE = Math.log(valor1);                   //base e
        double logaritmo10 = Math.log10(valor1);                //base 10
        int numeroMax = Math.max(numero,numero2);               //Return max number
        int numeroMin = Math.min(numero,numero2);               //Return min number
        int convertNegative = Math.negateExact(numero);         //Convert To Negative Number
        int redondeado = Math.round(10.5F);                     //Return round number
        double radiantes = Math.toRadians(valor1);              //Tranform to Radians

        System.out.println("Valor " + valor1);
        System.out.println("Potencia Cuadrado: " + potencia);
        System.out.println("Raiz: " + raiz);
        System.out.println("Random: " + numeroRandom);
        System.out.println("Coseno: " + coseno);
        System.out.println("Seno: " + seno);
        System.out.println("Tangente: " + tangente);
        System.out.println("Numero Absoluto: " + numeroAbsoluto);
        System.out.println("Logaritmo base e: " + logaritmoE);
        System.out.println("Logaritmo base 10: " + logaritmo10);
        System.out.println("Valor Max: " + numeroMax);
        System.out.println("Valor Min: " + numeroMin);
        System.out.println("Numero Positivo a negativo: " + convertNegative);
        System.out.println("Numero Redondeado: " + redondeado);
        System.out.println("Numero a Radianes: " + radiantes);
    }

}
