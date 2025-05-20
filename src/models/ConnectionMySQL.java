
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMySQL {
    
    private String database_name = "Farmacia";
    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:8080/" + database_name;
    Connection conn = null;
    
    public Connection getConnection(){
        try{
            //Obtener valor del Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener la conexión
            conn = DriverManager.getConnection(url, user, password);
            
        }catch(ClassNotFoundException e){
            System.err.println("Ha ocurrido un ClassNotFoundException " + e.getMessage());
        }catch(SQLException e){
            System.err.println("Ha ocurrido un SQLException " + e.getMessage());
        }
        return conn;
    }
    
}
