package Intermedio.BBDD_remote;

import java.sql.*;

public class principal {

    private static final String URL = "jdbc:mysql://us-east.connect.psdb.cloud/javaremota?sslMode=VERIFY_IDENTITY";
    private static final String USER = "ed4n2hc3mlp7mtb6nlqw";
    private static final String PASSWORD = "pscale_pw_D6eq9psv0XUcSm4kIlyb4U2f9Gi3W5pfu483J1gCdVU";

    public static Connection get_connection(){
        Connection conection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);

            System.out.println("Se conecto con exito");
        }catch (Exception e){
            System.out.println(e);
        }
        return conection;
    }

    public static void readProductos(){
        PreparedStatement ps = null; //Damos el Qruery
        ResultSet rs = null;        //permite traer los datos en filas

        try(Connection con = get_connection()) {

            String query = "SELECT * FROM products;";
            ps = con.prepareStatement(query);
            //Obtenemos los datos
            rs = ps.executeQuery();

            //Mientras que obtenga datos
            while(rs.next()){
                int id = rs.getInt(rs.getInt(1));
                String productos = rs.getString(2);
                Float precio = rs.getFloat(3);

                System.out.print(id + "     ");
                System.out.print(productos + "    ");
                System.out.println(precio + "   ");
            }

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void readProducto(int id){
        PreparedStatement ps = null; //Damos el Qruery
        ResultSet rs = null;        //permite traer los datos en filas

        try(Connection con = get_connection()) {

            String query = "SELECT * FROM products WHERE id=" + id + ";";
            ps = con.prepareStatement(query);
            //Obtenemos los datos
            rs = ps.executeQuery();

            rs.next();
            int f = rs.getInt(1);
            String productos = rs.getString(2);
            Float precio = rs.getFloat(3);

            System.out.print(f + "     ");
            System.out.print(productos + "    ");
            System.out.println(precio + "   ");

        }catch(SQLException e){
            System.err.println(e);
        }
    }


    public static void main(String[] args) {
        System.out.println("CONECTIN...");
        readProducto(3);
    }
}
