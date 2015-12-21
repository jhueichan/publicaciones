
package com.action;

import com.dao.DaoUsuario;
import com.model.Usuario;
import com.opensymphony.xwork2.Action;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class LoginAction extends ActionSupport{
  private DaoUsuario dao = new DaoUsuario();
   private Usuario usuario;
   private String usu;
   private String cla;
    
    public String iniciarSesion() throws Exception{      
        try{
            System.out.println(usu+" - "+cla);
//           record = dao.validarUsuarioEmp(usu, cla);
           System.out.println("bienvenido: "+usuario.getPrimerApellido()+" desde el metodo iniciar sesion ");
        }catch(Exception e){
            System.out.println("error validacion en el action ----> IniciarSesion"+e.getMessage());
           
            e.printStackTrace();
        }
        if(usuario.getRut()!=null && !usuario.getRut().isEmpty()){
            Map<String, Object>sesionUsuario = ActionContext.getContext().getSession();
            sesionUsuario.put("sesionUsuario",usuario);    
            addActionMessage("Bienvenido : " +usuario.getRut());
            //return SUCCESS;
            return Action.SUCCESS;
        }else{
            addActionError("Usuario y Clave son Incorrecto");
            //return ERROR;
            return Action.ERROR;
        }
    } 
    
     public String cerrarSesion() {
        Map sessionLogout = ActionContext.getContext().getSession();
        sessionLogout.remove("sesionUsuario");
        addActionMessage("Has salido de su sesion");
        return SUCCESS;
     
     }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
     
     
     
     
}