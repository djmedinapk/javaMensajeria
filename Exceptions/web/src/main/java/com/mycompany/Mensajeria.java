/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import Controller.JmsLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 * bean Mensajeria apra la vista index
 * @author DJMEDINA
 */
@Named(value = "mensajeria")
@SessionScoped
public class Mensajeria implements Serializable {

    /**
     * ejb de jms
     */
    @EJB
    JmsLocal jmsLocal;
    
   /**
    * texto que se envia al jms
    */
    private String mensaje;
    
            
    /**
     * Creates a new instance of Mensajeria
     */
    public Mensajeria() {
    }

    public void enviarMensaje(){
        jmsLocal.sendMessage(mensaje);
    }
    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
