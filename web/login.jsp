<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sito Web Publicaciones</title>
        <sj:head jqueryui="true" jquerytheme="blitzer"></sj:head>
        <meta content="width=device-width, initial-scale=1.0, user-scalable=no" name="viewport">
        <script type="text/javascript" src="../../html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
        <s:fielderror theme="bootstrap"/>
      <div class="container-fluid">
      <div class="dashboard-container">
      
        <div class="dashboard-wrapper">
          <div class="left-sidebar">
            
            <div class="row-fluid">
              
              <div class="span12">
                <div class="widget">
                  <div class="widget-header">
                    <div class="title">
                    Iniciar Sesion
                    </div>
                    <span class="tools">
                   
                    </span>
                  </div>
                  <div class="widget-body">
                    <div class="span3">&nbsp;</div>
                    <div class="span6">
                      <div class="sign-in-container">
                      <s:form action="loginAction" cssStyle="login-wrapper">
                          <div class="header">
                            <div class="row-fluid">
                              <div class="span12">
                                 <h3>Iniciar Sesion<img src="Bootstrap/img/logo1.png" alt="Sitio Web Publicaciones" class="pull-right"></h3>
                                <p>Ingrese con su usuario y clave</p>
                              </div>
                            </div>
                          </div>
                            <s:textfield label="usuario" name="rutIngresado" placeholder="Rut" required="required" class="input span12 " ></s:textfield>
                            <s:password label="contraseña" name="passwordIngresada" cssClass="input password" placeholder="Password" required="required"></s:password>
                        </div>
                          <div class="actions">
                          <s:submit cssClass="btn btn-primary bottom-margin" value="Entrar"></s:submit>
                          <div class="clearfix"></div>
                            </div>
                        </s:form>
                      </div>
                    </div>
                    <div class="span3">&nbsp;</div>
                    <div class="clearfix"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    
    </body>
</html>
