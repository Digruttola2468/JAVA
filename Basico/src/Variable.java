public class Variable {
    //Global
    int numeroGlobal = 10;

    public static void main(String[] args) {
        //Local
        int numero = 0;                             //range -2147483648 to 2147483647
        long numeroLong = -50;                      //range -9223372036854775808 to 9223372036854775807L
        float numeroFloat = 0.8F;                   //range 1.40239846e-45F to 3.40282347e+38F
        double numeroDouble = 0.8;                  //range 4.94065645841246544e-324 to 1.79769313486231570e+308
        String cadenaTexto = "Ivan Di Gruttola";    //Text field
        char Char = 'F';                            //Single field
        byte Byte = -128;                           //range -128 to 127
        Boolean isTrue = false;                     //true = 1 , false = 0

        System.out.println("Int: " + numero);
        System.out.println("Long: " + numeroLong);
        System.out.println("Float: " + numeroFloat);
        System.out.println("Double: " + numeroDouble);
        System.out.println("String: " + cadenaTexto);
        System.out.println("Byte: " + Byte);
        System.out.println("Char: " + Char);
        System.out.println("Boolean: " + isTrue);
        System.out.println("Variable Global: " + new Variable().numeroGlobal);
    }

}
