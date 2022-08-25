package Avanzado.InyeccionDependencias;

public class Clima {

    //Dependencias
    private Temperatura temperatura;
    private Humedad humedad;

    /*
    //Inyeccion de Dependencia definidas en el constructor
    public Clima() {
        temperatura = new Temperatura();
        humedad = new Humedad();
    }
    */

    //Inyeccion de Dependencia al Constructor de la clase
    //para que no sea él el que tenga que definirlas en el constructor (como el anterior).
    public Clima(Temperatura temperatura,Humedad humedad){
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public void imprimir(){
        temperatura.mostrarTemperatura();
        humedad.mostrarHumedad();
    }

    public static void main(String[] args) {
        new Clima(new TemperaturaFahrenheit(),new Humedad()).imprimir();
    }
}
