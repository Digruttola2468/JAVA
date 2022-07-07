package Intermedio.BBDD;

import java.sql.*;

public class PersonaBBDD {

    public static void CreatePersona(Personas persona){
        Conexion db_connect = new Conexion();
        try (Connection con = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO persona (`nombre`, `apellido`, `edad`, `fechaNacimiento`, `sueldo`) VALUES (?, ?, ?, ?, ?);";
                ps = con.prepareStatement(query);
                ps.setString(1, persona.getNombre());
                ps.setString(2,persona.getApellido());
                ps.setInt(3,persona.getEdad());
                ps.setString(4, persona.getFechaNacimiento());
                ps.setFloat(5, persona.getSueldo());
                ps.executeUpdate();
                System.out.println("Persona creada");

            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void ReadPersonas(){
        Conexion conexion = new Conexion();
        PreparedStatement ps = null; //Damos el Qruery
        ResultSet rs = null;        //permite traer los datos en filas

        try(Connection con = conexion.get_connection()) {

            String query = "SELECT * FROM conectjava.persona;";
            ps = con.prepareStatement(query);
            //Obtenemos los datos
            rs = ps.executeQuery();

            //Mientras que obtenga datos
            while(rs.next()){
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Apellido: " + rs.getString(3));
                System.out.println("Edad: " + rs.getInt(4));
                System.out.println("FechaNacimiento: " + rs.getDate(5));
                System.out.println("Sueldo: " + rs.getFloat(6));
                System.out.println();
                System.out.println("-----------------------------------------------------");
                System.out.println();
            }

        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void DeletePersona(int id_persona){
        Conexion conexion = new Conexion();

        try(Connection con = conexion.get_connection()) {
            PreparedStatement ps = null; //Damos el Qruery

            String query = "DELETE FROM `persona` WHERE (`idPersona` = ?);";
            ps = con.prepareStatement(query);
            ps.setInt(1, id_persona);
            ps.executeUpdate();
            System.out.println("\nPersona Eliminada\n");
        }catch(SQLException e){
            System.err.println(e);
        }

    }

    public static void UpdatePersona(Personas persona){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE `conectjava`.`persona` SET `nombre` = ?, `apellido` = ?, `edad` = ?, `fechaNacimiento` = ?, `sueldo` = ? WHERE (`idPersona` = ?)";
                ps = con.prepareStatement(query);
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getApellido());
                ps.setInt(3,persona.getEdad());
                ps.setString(4, persona.getFechaNacimiento());
                ps.setFloat(5,persona.getSueldo());
                ps.setInt(6, persona.getId());

                ps.executeUpdate(); //ejecutamos el query
                System.out.println("La persona se actualizo correctamente");

            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
