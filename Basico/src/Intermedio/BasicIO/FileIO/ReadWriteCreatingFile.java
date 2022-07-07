package Intermedio.BasicIO.FileIO;

import static java.nio.file.StandardOpenOption.*;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteCreatingFile {
    //static File file = new File("filename.txt"); // Specify the filename
    static Path file = Paths.get("filename.txt");


    public static void main(String[] args) {
        /*CreateFiles();
        WritingFileUsingBuffered("Ejemplo\nCreate\nRead\nWrite");
        ReadingFileUsingBuffered();*/
        while(true){
            CreatingTemporaryFiles();
        }
    }

    private static void CreatingTemporaryFiles(){
        //Path file2 = Paths.get(System.getProperty("user.home"),"Desktop");
        try {
            Path tempFile = Files.createTempFile(null, ".txt");
            System.out.format("The temporary file" +
                    " has been created: %s%n", tempFile);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private static void CreateFiles(){
        try {
            // Create the empty file with default permissions, etc.
            Files.createFile(file);

        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s" +
                    " already exists%n", file);
        } catch (IOException x) {
            // Some other sort of failure, such as permissions.
            System.err.format("createFile error: %s%n", x);
        }
    }





    //STREAM IO
    private static void CreateAndWritingFileUsingStreamIO(String text){
        // Convert the string to a
        // byte array.
        byte data[] = text.getBytes();
        Path p = Paths.get("./logfile.txt");

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /*To open a file for reading, you can use the newInputStream(Path, OpenOption...) method.
     This method returns an unbuffered input stream for reading bytes from the file.*/
    private static void ReadingFilebyUsingStreamIO(){
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }





    //Stream IO
    private static void WritingFileUsingBuffered(String txt){
        //Charset charset = Charset.forName("US-ASCII");
        Charset charset = StandardCharsets.US_ASCII;

        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(txt, 0, txt.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private static void ReadingFileUsingBuffered(){
        //Charset charset = Charset.forName("US-ASCII");
        Charset charset = StandardCharsets.US_ASCII;
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
