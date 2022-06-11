package Intermedio;

public class Final {
    //Con valor
    final String valor = "valor";

    //sin valor, agregando obligatoriamente en un constructor
    final String valor2;
    public Final(String valor2) {
        this.valor2 = valor2;
    }

    //No se puede usar Setters, no se puede modificar el valor
    public String getValor() {
        return valor;
    }

    public String getValor2() {
        return valor2;
    }

    public static void main(String[] args) {
        Final fin = new Final("valor2");
        System.out.println(fin.getValor());
        System.out.println(fin.getValor2());
    }
}
