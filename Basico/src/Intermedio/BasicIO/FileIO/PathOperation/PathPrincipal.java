package Intermedio.BasicIO.FileIO.PathOperation;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
* A Path instance contains the information used to specify the location of a file or directory.
* At the time it is defined, a Path is provided with a series of one or more names.
* A root element or a file name might be included, but neither are required.
* A Path might consist of just a single directory or file name.
* */

public class PathPrincipal {
    public static void main(String[] args) {
        //You can easily create a Path object by using one of the following get methods from the Paths helper class:

        Path p1 = Paths.get("/tmp/foo");
        Path p2 = Paths.get("src/Intermedio/BasicIO/FileIO/","inicio.html");
        Path p3 = Paths.get(URI.create("file:///BasicIO/FileIO/FileTest.java"));

        //The Paths.get method is shorthand for the following code:
        Path p4 = FileSystems.getDefault().getPath("/users/sally");
        //The following example creates /u/joe/logs/foo.log assuming your home directory is /u/joe, or C:\joe\logs\foo.log if you are on Windows.

        Path p5 = Paths.get(System.getProperty("user.home"),"desktop","Java");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

        // Microsoft Windows syntax
        //Path path = Paths.get("C:\\home\\joe\\foo");

        System.out.println();
        System.out.println();

        // Solaris syntax
        Path path = Paths.get("/home/joe/foo");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());
    }
}
