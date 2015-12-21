

package com.model;

import java.sql.Date;


public class Password {
    
    private  int idpasswd;
    private  Date fechaMod;
    private  String password;
    private  Usuario usuario;

    public Password() {
    }

    public int getIdpasswd() {
        return idpasswd;
    }

    public void setIdpasswd(int idpasswd) {
        this.idpasswd = idpasswd;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
