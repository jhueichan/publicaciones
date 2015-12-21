/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Publicacion;
import static com.service.PublicacionInterface.dbConnection;
import com.service.PublicacionInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class DaoPublicacion implements PublicacionInterface{
       PreparedStatement pStmt; 

    public DaoPublicacion() {
       
    }
       
    @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM publicacion WHERE id_publicacion = ?";
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
     List<Publicacion> publicaciones = new ArrayList<Publicacion>();        
	String query = "SELECT * FROM publicacion";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Publicacion publicacion = new Publicacion();
			publicacion.setIdpub(rs.getInt(1));
			publicacion.setPublicacion(rs.getString(2)); 
                        publicacion.setExtension(rs.getString(3));
                        publicacion.setFechaMod(rs.getDate(4));
                        publicaciones.add(publicacion);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return publicaciones;
    }

    @Override
    public boolean ingresar(Publicacion obj) throws Exception {
       String insertQuery = "INSERT INTO publicacion VALUES (publicacion_SEQ.NextVal,?,?,?)";
       try {
        	    pStmt = dbConnection.prepareStatement(insertQuery);                     
                    pStmt.setString(1, obj.getPublicacion());	
                    pStmt.setString(2, obj.getPublicacion());	
                    pStmt.setDate(3, obj.getFechaMod());
        	    pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(Publicacion obj) throws Exception {
      
      String updateQuery = "UPDATE publicacion SET nombre_publicacion = ? extension = ? fecha_mod = ? WHERE id_publicacion  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getPublicacion());
                pStmt.setString(2, obj.getExtension());
                java.sql.Date fexa = new java.sql.Date(0); 
                pStmt.setDate(3, fexa);
		pStmt.setInt(4, obj.getIdpub());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  Publicacion buscarPorID(int id) throws Exception {
     Publicacion publicacion=new Publicacion();
     String query = "SELECT * FROM publicacion WHERE id_publicacion = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 publicacion.setIdpub(rs.getInt(1));
                          publicacion.setPublicacion(rs.getString(2));
                          publicacion.setExtension(rs.getString(2));                          
                         publicacion.setFechaMod(rs.getDate(4));
			
		} 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  publicacion;   
    }

}
