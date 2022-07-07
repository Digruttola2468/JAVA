package Intermedio.BasicIO.FileIO;

import java.io.*;
import java.util.Scanner;

public class FilesHandling {

    static File myObj = new File("filename.txt"); // Specify the filename

    public static void main(String[] args) {
        createFile();
        WriteFile("Feliz dia\nTe Queremos Mucho");
        ReadFile();
        ScannReadFile();
        FileInformation();
        deleteFile();
    }

    private static void createFile(){
        try{
            if(myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }else
                System.out.println("File Already exists.");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
    private static void WriteFile(String text) {
        try {

            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file");
        }catch (IOException e){

            System.err.println(e.getMessage());
        }
    }
    private static void ReadFile(){
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(myObj));
            String line;
            while ( (line = myReader.readLine() ) != null)
                System.out.println(line);

            myReader.close();

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    private static void ScannReadFile(){
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                //String data = myReader.nextLine();
                String data = myReader.next();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void FileInformation(){
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    private static void deleteFile(){
        if(myObj.exists()){
            myObj.delete();
            System.out.println("Deleted File");
        }
        else
            System.out.println("Cant deleted File");
    }
}
