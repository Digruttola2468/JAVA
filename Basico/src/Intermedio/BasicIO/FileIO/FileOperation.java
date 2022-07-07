package Intermedio.BasicIO.FileIO;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.*;

public class FileOperation {
    private static final Path p1 = Paths.get(System.getProperty("user.home"),"desktop");

    public static void main(String[] args) throws IOException {
        VerifyingExistenceFileOrDirectory();
        CheckingFileAccessibility();
        CheckingWhetherTwoPathsLocateSameFile();
        DeletingFileorDirectory();
    }

    private static void VerifyingExistenceFileOrDirectory(){
        //IF there is file --> TRUE
        if(Files.exists(p1)) System.out.println("Exists");
        else System.err.println("No Exists");

        //IF there is no file --> TRUE
        if(Files.notExists(p1)) System.err.println("No Exists");
        else System.out.println("Exists");
    }

    private static void CheckingFileAccessibility(){
        boolean isRegularExecutableFile = Files.isRegularFile(p1) &
                Files.isReadable(p1) & Files.isExecutable(p1);
        if(isRegularExecutableFile) System.out.println("Is Accessible");
        else System.err.println("No Accessible");
    }

    private static void CheckingWhetherTwoPathsLocateSameFile() throws IOException {
        Path p2 = Paths.get(System.getProperty("user.home"),"desktop");

        if (Files.isSameFile(p1, p2)) System.err.println("Are same Files");
        else System.out.println("Are not Same Files");
    }

    private static void DeletingFileorDirectory() {
        Path p2 = Paths.get(System.getProperty("user.home"),"desktop","Prueba.txt");

        try {
            if(Files.deleteIfExists(p2)){
                Files.delete(p2);
                System.out.println("File Deleted");
            }else
                System.out.println("Cant Deleted File");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
