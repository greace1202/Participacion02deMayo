package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    static String usuario = "root";
    static String password = "admin";
    
    Connection conn = null;
    
    public ConexionBD(){
        try{
            //Especifiacion del driver
            Class.forName(driver);
            //Establece la conexion con la base de datos
            conn = DriverManager.getConnection(url, usuario, password);
            //verificar la conexion
            if(conn != null){
                System.out.println("Conexion OK: "+ conn);
            }
        }catch(SQLException ex){
            System.out.println("Error de sql: "+ex.getMessage());
        }catch(ClassNotFoundException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
