package Intermedio.Herencia.ejemplo2;

public class Valores {
    private double base = 10;
    private double altura = 10;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    void mostrarDimension(){
        System.out.println("La base y altura es: "+base+" y "+altura);
    }
}
