package Intermedio.BasicIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        String path = "BasicIO\\";
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(path + "archivo.txt");
            outputStream = new FileWriter(path + "characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
                System.out.println(c);
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