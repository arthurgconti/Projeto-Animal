/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.DAO;

import com.br.DTO.DonoDTOArthur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur Conti
 */
public class DonoDAOArthur {
    
    private Connection con;
    
    ResultSet rs;
    PreparedStatement pstm;
    Statement stmt;
    
    public DonoDAOArthur()
    {
        con = Conexao.ConectaBD();
    }
    
    public ResultSet listaBusca (){
        try{
            String comando = "select * from tbdono_arthur where cpf <> '00000000000'";
            stmt = Conexao.ConectaBD().createStatement();
            
            rs = stmt.executeQuery(comando);
            System.out.println(comando);
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao buscar Dono"
          ,JOptionPane.ERROR_MESSAGE);            
            return null;            
        }
    }
    
    public ResultSet entrarValidar(DonoDTOArthur dono){
        
        try{
            PreparedStatement pstm;
            ResultSet rs;            
            
            String comando = "select * from tbdono_arthur where cpf = ? and senha = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setString(1, dono.getCpf());
            pstm.setString(2,dono.getSenha());
            
            rs = pstm.executeQuery();
            
            return rs;
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao buscar Usuarios"
           ,JOptionPane.ERROR_MESSAGE);            
         return null;
        }
    }    
    
    public boolean validarDono(DonoDTOArthur dono){
        try{
        String comando = "select * from tbdono_arthur where cpf = ?";
        pstm=con.prepareStatement(comando);
        
        pstm.setString(1,dono.getCpf());
        
        rs = pstm.executeQuery();
        
            return !rs.next();
        
        
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao validar Usuario"
           ,JOptionPane.ERROR_MESSAGE);             
         return false;   
        }
    }
    
    public boolean inserirDono(DonoDTOArthur dono){
        try{
            if(validarDono(dono)==true){
                
            String comando = "insert into tbdono_arthur (nome,cpf,datanascimento,senha) values (?,?,?,?)";
            pstm = con.prepareStatement(comando);
            
            pstm.setString(1, dono.getNome());
            pstm.setString(2, dono.getCpf());
            pstm.setString(3, dono.getDataNascimento());
            pstm.setString(4, dono.getSenha());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "O cpf inserido já existe no sistema");
                return false;
            }
            
            
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao inserir Usuario"
           ,JOptionPane.ERROR_MESSAGE);            
         return false;            
        }
    }
    
    public boolean alterarDono(DonoDTOArthur dono){
        try{
            String comando = "update tbdono_arthur set nome = ?, cpf=?,datanascimento=?, senha=? where iddono = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setString(1,dono.getNome());
            pstm.setString(2,dono.getCpf());
            pstm.setString(3,dono.getDataNascimento());
            pstm.setString(4,dono.getSenha());
            pstm.setInt(5,dono.getIdDono());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao alterar Usuario"
          ,JOptionPane.ERROR_MESSAGE);            
            return false;                        
        }        
    }
    
    public ResultSet selecionaCampos(DonoDTOArthur dono)
    {
        try{
            String comando= "select * from tbdono_arthur where iddono = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setInt(1, dono.getIdDono());
            
            ResultSet rs = pstm.executeQuery();
            System.out.println(comando);
            
            return rs;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao Concetar ao BD"
           ,JOptionPane.ERROR_MESSAGE);     
            return null;
        }
    }    

    public boolean excluirDono(DonoDTOArthur dono) {
    try{
            String comando = "delete from tbdono_arthur where iddono = ?";
            pstm = con.prepareStatement(comando);
            
            pstm.setInt(1, dono.getIdDono());
            
            pstm.execute();
            System.out.println(comando);
            pstm.close();
            
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao deletar Usuario"
          ,JOptionPane.ERROR_MESSAGE);            
            return false;              
        }        
    }
}
