package modeloControlador;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloDatos {

    ///////// Atributos/////////
    private Connection conexion;
    private Statement set;
    private ResultSet resultSet;
    private String url, usuario, contrasenya;

    public void abrirConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            url = "jdbc:postgresql://localhost:5432/basededatos";
            usuario = "postgres";
            contrasenya = "admin";
            conexion = DriverManager.getConnection(url, usuario, contrasenya);
            System.out.println("Se ha conectado con la BD.");
        } catch (Exception ex) {
            System.out.println("No se ha conectado con la BD.");
        }
    }

    public String obtenerFacultades() {
        ArrayList<Facultad> facultades = new ArrayList<>();
        String query = "SELECT id, nombre, ST_Y(ubicacion::geometry) AS lat, ST_X(ubicacion::geometry) AS lon, radio, descripcion, imagen FROM facultades;";
        /*"ST_Y(ubicacion::geometry) AS lat, ST_X(ubicacion::geometry) AS lon" --> Devuelve las coordendas de la facultad*/
        Gson gson = new Gson();
        try {
            set = conexion.createStatement();
            resultSet = set.executeQuery(query);
            while (resultSet.next()) {
                Double[] coord = {resultSet.getDouble("lon"), resultSet.getDouble("lat")};
                facultades.add(new Facultad(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("descripcion"), resultSet.getString("imagen"), coord, resultSet.getInt("radio")));
            }
            resultSet.close();
            set.close();
        } catch (Exception ex) {
            System.out.println("No se obtiene de la tabla de Facultades.");
        }
        return gson.toJson(facultades);
    }

    // Metodo para cerrar la conexion con la base de datos.
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception ex) {
            System.out.println("No se ha podido cerrar la conexion.");
        }
    }
}
