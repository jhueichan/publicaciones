/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Password;
import com.model.Usuario;
import com.service.PasswordInterface;
import static com.service.PasswordInterface.dbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge
 */
public class DaoPassword implements PasswordInterface{
   PreparedStatement pStmt; 
 
   DaoUsuario daoUsuario;
    public DaoPassword() {
    daoUsuario = new DaoUsuario(); 
    }

    
    
    
    @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM ROL WHERE id_passwd = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
                return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}
        
    }

    @Override
    public List listar() throws Exception {
     List<Password> passwords = new ArrayList<Password>();        
	String query = "SELECT * FROM password";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Password passwd = new Password();
			passwd.setIdpasswd(rs.getInt(1));
			passwd.setFechaMod(rs.getDate(2)); 
                        passwd.setPassword(rs.getString(3));
                        Usuario u = daoUsuario.buscarPorID(rs.getInt(4));                       
                        passwd.setUsuario(u);          
                        passwords.add(passwd);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return passwords;
    }

    @Override
    public boolean ingresar(Password obj) throws Exception {
       String insertQuery = "INSERT INTO password VALUES (ROL_SEQ.NextVal,?,?,?)";
       try {
        	    pStmt = dbConnection.prepareStatement(insertQuery);     
                    pStmt.setDate(1, obj.getFechaMod());
                    pStmt.setString(2, obj.getPassword());	
                    pStmt.setInt(3, obj.getUsuario().getId());	
        	    pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(Password obj) throws Exception {
      
      String updateQuery = "UPDATE password SET password = ? fecha_mod = ? WHERE id_passwd  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getPassword());
                java.sql.Date fexa = new java.sql.Date(0); 
                pStmt.setDate(2, fexa);
		pStmt.setInt(3, obj.getIdpasswd());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  Password buscarPorID(int id) throws Exception {
     Password passwd=new Password();
     String query = "SELECT * FROM password WHERE id_passwd = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                    passwd.setIdpasswd(rs.getInt(1));
                    passwd.setFechaMod(rs.getDate(2));
                    passwd.setPassword(rs.getString(3));
                    Usuario usuario = daoUsuario.buscarPorID(rs.getInt(4));
                    passwd.setUsuario(usuario);
                    
			
		} 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  passwd;   
    }

    
}
