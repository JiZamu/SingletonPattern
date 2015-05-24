/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author eduardo
 */
public class UConnection {
    
    private static Connection  con = null;
    
    public static Connection getConnection(){
        try{
            if (con == null){
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost/PRUEBAS";
                String user = "while"; 
                String pass = "JiZa..";
            
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pass);
            }
            return con;   
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al crear la conexion", e);
        }
        
        }

    }

    class MiShDwnHook extends Thread{
        @Override
        public void run(){
            try{
                Connection con = UConnection.getConnection();
                con.close();
            } catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    
    
}
