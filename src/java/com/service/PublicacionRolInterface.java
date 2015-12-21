/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.jdbc.DataAccessObject;
import com.model.RolPublicacion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface PublicacionRolInterface {
     public static Connection dbConnection = DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List <RolPublicacion> listar() throws Exception;
    public boolean ingresar(RolPublicacion obj) throws Exception;   
    public boolean actualizar(RolPublicacion obj) throws Exception;
    public RolPublicacion buscarPorID(int id) throws Exception;
}
