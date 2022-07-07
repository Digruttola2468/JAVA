package Intermedio.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion{

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String NAME_BASEDATE = "conectjava";   //Nombre de la base de datos

    public Connection get_connection(){
        Connection conection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection(URL + NAME_BASEDATE, "root", "autito84");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conection;
    }

}