/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Publicacion;
import com.model.Rol;
import com.model.RolPublicacion;
import com.service.PublicacionRolInterface;
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
public class DaoRolPublicacion implements PublicacionRolInterface{
  PreparedStatement pStmt; 
  DaoRol daoRol;
  DaoPublicacion daoPublicacion;
  
    public DaoRolPublicacion() {
        daoRol= new DaoRol();
        daoPublicacion= new DaoPublicacion();
    }

     @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM rol_publicacion WHERE id = ?";
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
     List<RolPublicacion> roles = new ArrayList<RolPublicacion>();        
	String query = "SELECT * FROM rol_publicacion";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
                    RolPublicacion rolPublicacion = new RolPublicacion();
                        rolPublicacion.setId(rs.getInt(1));           
                        Rol rol= daoRol.buscarPorID(rs.getInt(2));
			rolPublicacion.setRol(rol);   
                        Publicacion publicacion=daoPublicacion.buscarPorID(rs.getInt(3));
                        rolPublicacion.setPublicacion(publicacion);
                        roles.add(rolPublicacion);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return roles;
    }

    @Override
    public boolean ingresar(RolPublicacion obj) throws Exception {
       String insertQuery = "INSERT INTO rol_publicacion VALUES (rol_publicacion_seq.NextVal,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setInt(1, obj.getId());	
                pStmt.setInt(2, obj.getPublicacion().getIdpub());
                pStmt.setInt(3, obj.getRol().getId());
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(RolPublicacion obj) throws Exception {
      String updateQuery = "UPDATE rol_publicacion SET publicacion_id_publicacion = ? "
                             + " rol_id_rol= ? WHERE id  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setInt(1, obj.getPublicacion().getIdpub());
		pStmt.setInt(2, obj.getRol().getId());
		pStmt.executeUpdate();
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  RolPublicacion buscarPorID(int id) throws Exception {
     RolPublicacion rolPublicacion=new RolPublicacion();
     String query = "SELECT * FROM rol_publicacion WHERE id = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
		        rolPublicacion.setId(rs.getInt(1));           
                        Rol rol= daoRol.buscarPorID(rs.getInt(2));
			rolPublicacion.setRol(rol);   
                        Publicacion publicacion=daoPublicacion.buscarPorID(rs.getInt(3));
                        rolPublicacion.setPublicacion(publicacion);
		} 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  rolPublicacion;   
    }
}
