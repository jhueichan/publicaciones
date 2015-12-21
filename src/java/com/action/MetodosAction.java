
package com.action;

import com.dao.DaoUsuario;
import com.model.Password;
import com.model.Usuario;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;


public class MetodosAction extends ActionSupport{

    private String rutIngresado;
    private String passwordIngresada;
    
     public boolean credencialesVacias(){
          if (rutIngresado==null || passwordIngresada==null) {
             return true;
          } else {
              return false;
          }     
      }
      
      
      public String IniciarSesion() throws Exception{
          
          Usuario usuario= new Usuario();
          Password passwd= new Password();
          DaoUsuario  daoUsuario = new DaoUsuario();
          if (credencialesVacias()) {
              addActionMessage("error, Ingrese credenciales ");            
              return  ERROR;           
          } else {
                     try { 
                         int pass=Integer.parseInt(rutIngresado);
                         usuario = daoUsuario.buscarPorID(pass);
                                        
                      } catch (Exception e) {
                          addActionMessage("el usuario no existe, ingrese un rut valido");        
                          System.out.println(e.getMessage());  
                          return ERROR;      
                      }

                     if (passwordIngresada.equals(passwd.getPassword())) {
                        
                        System.out.println("los rut son iguales ");    
                        DaoPrivilegiosPagina daoPrivilegiosPagina= new DaoPrivilegiosPagina();                 
                        listarPaginas= daoPrivilegiosPagina.ListaPriviPaginaPorRol(usuario.getRol_id());
                        
                         Map <String, Object> sesionUsuario = ActionContext.getContext().getSession();
                         sesionUsuario.put("sesionUsuario", usuario);                      
                         addActionMessage("Bienvenido : " + usuario.getNombres()+" "+usuario.getApellidos());   
                         return SUCCESS;  
                    } else {           
                          addActionError("la  password son Incorrectos");
                          return ERROR;      
                    }        
          }         
    } 

    public String getRutIngresado() {
        return rutIngresado;
    }

    public void setRutIngresado(String rutIngresado) {
        this.rutIngresado = rutIngresado;
    }

 
    public String getPasswordIngresada() {
        return passwordIngresada;
    }

    public void setPasswordIngresada(String passwordIngresada) {
        this.passwordIngresada = passwordIngresada;
    }
      
      
      
   
}
