package Intermedio.BasicIO.StreamIO.Scann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerArchivo {
    public static void main(String[] args) throws IOException {
        String path = "BasicIO\\";
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(path + "archivo.txt")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
