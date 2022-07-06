package Intermedio.BasicIO.StreamIO;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        String path = "BasicIO\\";

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(path + "archivo.txt"));
            outputStream = new PrintWriter(new FileWriter(path + "characteroutput.txt"));

            String l;
            while ( (l = inputStream.readLine()) != null) {
                outputStream.println(l);
                System.out.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
