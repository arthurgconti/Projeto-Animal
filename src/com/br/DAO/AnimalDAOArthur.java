/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.DAO;

import com.br.DTO.AnimalDTOArthur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur Conti
 */
public class AnimalDAOArthur {
    
    public AnimalDAOArthur(){
        con = Conexao.ConectaBD();
    }
    
    private Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement pstm;
    
    public ResultSet listaBusca(){
         try{
            String comando = "select a.idanimal,a.nome,d.nome,r.nome,a.dataadocao from tbanimal_arthur a "
                    + "inner join tbdono_arthur d on (d.iddono = a.coddono) "
                    + "inner join tbraca_arthur r on (r.idraca = a.codraca)";
            stmt = Conexao.ConectaBD().createStatement();
            
            rs = stmt.executeQuery(comando);
            System.out.println(comando);
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao buscar Animal"
          ,JOptionPane.ERROR_MESSAGE);            
            return null;            
        }
    }
    
    public ResultSet pesquisaDono(){
        try{
            stmt = Conexao.ConectaBD().createStatement();
            String comando = "select iddono, nome from tbdono_arthur where cpf <>'00000000000'";
            System.out.println(comando);
            
            rs = stmt.executeQuery(comando);
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao buscar dono"
           ,JOptionPane.ERROR_MESSAGE);
           return null;                          
        }
    }
    
    public ResultSet pesquisaRaca(){
        try{
            stmt = Conexao.ConectaBD().createStatement();
            String comando = "select idraca, nome from tbraca_arthur";
            System.out.println(comando);
            
            rs = stmt.executeQuery(comando);
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao buscar raça"
           ,JOptionPane.ERROR_MESSAGE);
           return null;                          
        }
    }

    public boolean inserirAnimal(AnimalDTOArthur animal) {
        try{
            String comando = "insert into tbanimal_arthur (codraca,coddono,nome,tamanho,fase,dataadocao) values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(comando);
            
            pstm.setInt(1,animal.getCodRaca());
            pstm.setInt(2,animal.getCodDono());
            pstm.setString(3,animal.getNome());
            pstm.setString(4,animal.getTamanho());
            pstm.setString(5,animal.getFase());
            pstm.setString(6,animal.getDataAdocao());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao inserir Animal"
          ,JOptionPane.ERROR_MESSAGE);            
            return false;
        }        
    }
    
 public ResultSet selecionaCampos(AnimalDTOArthur animal)
    {
        try{
            String comando= "select * from tbanimal_arthur where idanimal = ?";
            pstm = con.prepareStatement(comando);
            pstm.setInt(1, animal.getIdAnimal());
            
            rs = pstm.executeQuery();
            System.out.println(comando);
            
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao consultar o BD"
           ,JOptionPane.ERROR_MESSAGE);     
            return null;
        }
    }



    public boolean excluirAnimal(AnimalDTOArthur animal){
        try{
            String comando = "delete from tbanimal_arthur where idanimal = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setInt(1,animal.getIdAnimal());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao excluir Animal"
           ,JOptionPane.ERROR_MESSAGE);     
            return false;            
        }
    }
    
    public boolean alterarAnimal(AnimalDTOArthur animal){
        try{
            String comando = "update tbanimal_arthur set codraca =?,coddono = ?,nome = ?,"
                    + "tamanho = ?,fase =?, dataadocao=? where idanimal = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setInt(1, animal.getCodRaca());
            pstm.setInt(2, animal.getCodDono());
            pstm.setString(3,animal.getNome());
            pstm.setString(4,animal.getTamanho());
            pstm.setString(5,animal.getFase());
            pstm.setString(6,animal.getDataAdocao());
            pstm.setInt(7,animal.getIdAnimal());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao alterar Animal"
           ,JOptionPane.ERROR_MESSAGE);     
            return false;                   
        }
    }
    
}
