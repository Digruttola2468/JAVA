package Intermedio.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Fechas {
    public static void main(String[] args) throws ParseException {
        //Mostrar Fecha
        LocalDate myOb = LocalDate.now();
        System.out.println(myOb);

        //Mostrar Hora
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //Mostrar Hora - Fecha
        LocalDateTime fecha = LocalDateTime.now();
        System.out.println(fecha);

        //Formatiar Fecha y Tiempo
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before: " + myDateObj);
        //E, MMM dd yyyy , dd-MMM-yyyy , dd/MM/yyyy , yyyy-MM-dd
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After: " + formattedDate);

        //String a Date
        String stringfecha = "2023/10/14";
        Date formatFecha = new SimpleDateFormat("yyyy/MM/dd").parse(stringfecha);
        System.out.println(formatFecha);

        //String a Hora
        String stringHora = "12:40";
        Date formatHora = new SimpleDateFormat("HH:mm").parse(stringHora);
        System.out.println(formatHora);

        //StringHora y StringFecha Juntos
        Date allFomat = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(stringfecha + " " + stringHora);
        System.out.println(allFomat);

        //Date a String
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        System.out.println(strDate);
    }
}
