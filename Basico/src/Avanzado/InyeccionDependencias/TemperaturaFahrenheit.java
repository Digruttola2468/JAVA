package Avanzado.InyeccionDependencias;

public class TemperaturaFahrenheit extends Temperatura{

    @Override
    public void mostrarTemperatura() {
        System.out.println("Temperature: 66.2° Fahrenheit");

        super.mostrarTemperatura();
    }
}
