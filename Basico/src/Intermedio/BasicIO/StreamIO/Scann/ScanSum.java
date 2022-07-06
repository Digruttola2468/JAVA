package Intermedio.BasicIO.StreamIO.Scann;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class ScanSum {
    public static void main(String[] args) throws IOException {
        String path = "BasicIO\\Scann\\";
        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader(path + "usnumbers.txt")));
            /*
            Un objeto Locale representa una región geográfica, política o cultural específica.
            Una operación que requiere una configuración regional para realizar su tarea se denomina sensible
            a la configuración regional y utiliza la configuración regional para adaptar la información al usuario.
            Por ejemplo, mostrar un número es una operación sensible a la configuración regional:
            el número debe formatearse de acuerdo con las costumbres y convenciones del país,
            la región o la cultura de origen del usuario.
            */
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        }finally {
            if(s != null)
                s.close();
        }


        System.out.println(sum);
    }
}
