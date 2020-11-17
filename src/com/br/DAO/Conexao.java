/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author Arthur Conti
 */
public class Conexao {
    public static Connection ConectaBD(){
        
        Connection con = null;
        
        try{
            String url = "jdbc:mysql://localhost/animal_arthur?user=root&password=";
            
            con = DriverManager.getConnection(url);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao Concetar ao BD"
           ,JOptionPane.ERROR_MESSAGE);            
        }
        
        return con;
    }
}
