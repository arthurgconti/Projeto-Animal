/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.DAO;

import com.br.DTO.RacaDTOArthur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur Conti
 */
public class RacaDAOArthur {
    private Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    Statement stmt;
    
    public boolean inserirRaca(RacaDTOArthur raca){
        try{
            con = Conexao.ConectaBD();
            String comando = "insert into tbraca_arthur (nome) values (?)";
            pstm = con.prepareStatement(comando);
            pstm.setString(1,raca.getNome());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao inserir Raça"
          ,JOptionPane.ERROR_MESSAGE);            
            return false;
        }
    }
    
    public ResultSet listaBusca(){
        try{
            Conexao.ConectaBD();
            String comando = "select * from tbraca_arthur order by idraca";
            stmt= Conexao.ConectaBD().createStatement();
            
            rs = stmt.executeQuery(comando);
            System.out.println(comando);
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao buscar Raça"
          ,JOptionPane.ERROR_MESSAGE);            
            return null;            
        }
    }
    
    public boolean alterarRaca(RacaDTOArthur raca){
        try{
            con = Conexao.ConectaBD();
            String comando = "update tbraca_arthur set nome = ? where idraca = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setString(1,raca.getNome());
            pstm.setInt(2,raca.getIdRaca());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao alterar Raça"
          ,JOptionPane.ERROR_MESSAGE);            
            return false;                        
        }
    }
    
    
    public boolean excluirRaca(RacaDTOArthur raca){
        try{
            con = Conexao.ConectaBD();
            String comando = "delete from tbraca_arthur where idraca = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setInt(1, raca.getIdRaca());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao deletar Raça"
          ,JOptionPane.ERROR_MESSAGE);            
            return false;              
        }
    }
    
}
