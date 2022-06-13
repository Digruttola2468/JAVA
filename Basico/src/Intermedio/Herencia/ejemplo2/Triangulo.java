package Intermedio.Herencia.ejemplo2;

public class Triangulo extends Valores{

    String estilo;

    public double perimetro() {
        return getBase() * 3;
    }

    public double area(){
        return getBase()*getAltura()/2;
    }

    void mostrarEstilo(){
        System.out.println("Triangulo es: " + estilo);
    }
}
