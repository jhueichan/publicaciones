/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.jdbc.DataAccessObject;
import  com.model.Reparticion;
import java.sql.Connection;
import java.util.List;

public interface ReparticionInterface {
    public static Connection dbConnection = DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List <Reparticion> listar() throws Exception;
    public boolean ingresar(Reparticion obj) throws Exception;   
    public boolean actualizar(Reparticion obj) throws Exception;
    public Reparticion buscarPorID(int id) throws Exception;
   
}
