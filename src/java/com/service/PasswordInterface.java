/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Password;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jorge
 */
public interface PasswordInterface {
  public static Connection dbConnection = DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List <Password> listar() throws Exception;
    public boolean ingresar(Password obj) throws Exception;   
    public boolean actualizar(Password obj) throws Exception;
    public Password buscarPorID(int id) throws Exception;
}
