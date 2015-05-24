/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class Test {
    public static void main(String[] args) throws SQLException{
        String query = "select * from Libros";
        
        Connection  con = UConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString("isbn"));
        }
    }
}
