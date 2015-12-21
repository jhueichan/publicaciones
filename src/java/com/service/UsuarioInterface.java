
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Usuario;
import java.sql.Connection;
import java.util.List;


public interface UsuarioInterface {
     public static Connection dbConnection = DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List <Usuario> listar() throws Exception;
    public boolean ingresar(Usuario obj) throws Exception;   
    public boolean actualizar(Usuario obj) throws Exception;
    public Usuario buscarPorID(int id) throws Exception;
 
}
