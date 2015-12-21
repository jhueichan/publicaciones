/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Reparticion;
import com.model.Rol;
import com.model.Usuario;
import com.model.Usuario;
import static com.service.UsuarioInterface.dbConnection;
import com.service.UsuarioInterface;
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
public class DaoUsuario implements UsuarioInterface{
      PreparedStatement pStmt; 
        DaoRol daoRol;
        DaoReparticion daoReparticion;
    public DaoUsuario() {
        daoReparticion= new DaoReparticion();
        daoRol= new DaoRol();
      
    }
    
    
    

       @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM usuario WHERE id = ?";
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
     List<Usuario> usuarios = new ArrayList<Usuario>();        
	String query = "SELECT * FROM usuario";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt(1));
			usuario.setPrimerNombre(rs.getString(2)); 
                        usuario.setSegundoNombre(rs.getString(3));
                        usuario.setPrimerApellido(rs.getString(4)); 
                        usuario.setSegundoApellido(rs.getString(5));
                        usuario.setGrado(rs.getString(6)); 
                        usuario.setHabilitado(rs.getInt(7));
                        Rol rol= daoRol.buscarPorID(rs.getInt(8));
                        usuario.setRol(rol);
                        Reparticion reparticion= daoReparticion.buscarPorID(rs.getInt(9));
                        usuario.setReparticion(reparticion);
                        usuarios.add(usuario);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return usuarios;
    }

    @Override
    public boolean ingresar(Usuario obj) throws Exception {
       String insertQuery = "INSERT INTO usuario VALUES (usuario_SEQ.NextVal,?,?,?,?,?,?,?,?,?)";
       try {
        	    pStmt = dbConnection.prepareStatement(insertQuery);                     
                    pStmt.setString(1, obj.getRut());	
                    pStmt.setString(2, obj.getPrimerNombre());	
                    pStmt.setString(3, obj.getSegundoNombre());
                    pStmt.setString(4, obj.getSegundoNombre());	
                    pStmt.setString(5, obj.getSegundoApellido());	
                    pStmt.setString(6, obj.getGrado());
                    pStmt.setInt(7, obj.getHabilitado());	
                    pStmt.setInt(8, obj.getRol().getId());	
                    pStmt.setInt(9, obj.getReparticion().getIdRep());
        	    pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(Usuario obj) throws Exception {
      
      String updateQuery = "UPDATE usuario SET rut = ? primer_nombre = ? segundo_nombre = ?"
              + "  primer_apellido = ?  segundo_apelllido = ?  grado = ?  habilitado = ?"
              + " usuario_rol_id = ?  reparticion_id =?"
              + "WHERE id  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getRut());
                pStmt.setString(2, obj.getPrimerNombre());
                pStmt.setString(3, obj.getSegundoNombre());
                pStmt.setString(4, obj.getPrimerApellido());
                pStmt.setString(5, obj.getSegundoApellido());
                pStmt.setString(6, obj.getGrado());
                pStmt.setInt(7, obj.getHabilitado());
                pStmt.setInt(8, obj.getRol().getId());
              	pStmt.setInt(9, obj.getReparticion().getIdRep());
                pStmt.setInt(10,obj.getId());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  Usuario buscarPorID(int id) throws Exception {
     Usuario usuario=new Usuario();
     String query = "SELECT * FROM usuario WHERE id = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {			
			usuario.setId(rs.getInt(1));
			usuario.setPrimerNombre(rs.getString(2)); 
                        usuario.setSegundoNombre(rs.getString(3));
                        usuario.setPrimerApellido(rs.getString(4)); 
                        usuario.setSegundoApellido(rs.getString(5));
                        usuario.setGrado(rs.getString(6)); 
                        usuario.setHabilitado(rs.getInt(7));
                        Rol rol= daoRol.buscarPorID(rs.getInt(8));
                        usuario.setRol(rol);
                        Reparticion reparticion= daoReparticion.buscarPorID(rs.getInt(9));
                        usuario.setReparticion(reparticion);
			
		} 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  usuario;   
    }
    
}
