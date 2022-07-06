package Intermedio.BasicIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Programs use byte streams to perform input and output of 8-bit bytes. All byte stream classes are descended from InputStream and OutputStream.


public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "BasicIO\\";

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(path + "archivo.txt");
            out = new FileOutputStream(path + "ouput.txt");

            int c;
            while ( (c = in.read() ) != -1) {
                out.write(c);
                System.out.println(c);  //Return bytes
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}