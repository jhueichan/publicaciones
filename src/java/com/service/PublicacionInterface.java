/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Publicacion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface PublicacionInterface {
     public static Connection dbConnection = DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List <Publicacion> listar() throws Exception;
    public boolean ingresar(Publicacion obj) throws Exception;   
    public boolean actualizar(Publicacion obj) throws Exception;
    public Publicacion buscarPorID(int id) throws Exception;
}
