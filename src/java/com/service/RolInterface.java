/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.jdbc.DataAccessObject;
import java.sql.Connection;
import java.util.List;
import com.model.Rol;

/**
 *
 * @author jorge
 */
public interface RolInterface {
     public static Connection dbConnection = DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List <Rol> listar() throws Exception;
    public boolean ingresar(Rol obj) throws Exception;   
    public boolean actualizar(Rol obj) throws Exception;
    public Rol buscarPorID(int id) throws Exception;
}
