/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Reparticion;
import com.model.Reparticion;
import static com.service.ReparticionInterface.dbConnection;
import com.service.ReparticionInterface;
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
public class DaoReparticion implements ReparticionInterface{

    
    PreparedStatement pStmt; 

    public DaoReparticion() {
    }

       
   @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM reparticion WHERE id_reparticion = ?";
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
     List<Reparticion> reparticiones = new ArrayList<Reparticion>();        
	String query = "SELECT * FROM reparticion";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Reparticion reparticion = new Reparticion();
			reparticion.setIdRep(rs.getInt(1));
			reparticion.setNombre(rs.getString(2)); 
                       
                        reparticiones.add(reparticion);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return reparticiones;
    }

    @Override
    public boolean ingresar(Reparticion obj) throws Exception {
       String insertQuery = "INSERT INTO reparticion VALUES (reparticion_SEQ.NextVal,?)";
       try {
        	    pStmt = dbConnection.prepareStatement(insertQuery);                     
                    pStmt.setString(1, obj.getNombre());                  
        	    pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(Reparticion obj) throws Exception {
      
      String updateQuery = "UPDATE reparticion SET nombre_rep = ?  WHERE id_reparticion  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getNombre());
                pStmt.setInt(2, obj.getIdRep());
               
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  Reparticion buscarPorID(int id) throws Exception {
     Reparticion reparticion=new Reparticion();
     String query = "SELECT * FROM reparticion WHERE id_reparticion = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {

			reparticion.setIdRep(rs.getInt(1));
			reparticion.setNombre(rs.getString(2)); 
                       
                         
			
		} 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  reparticion;   
    }
}
