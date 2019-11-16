/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.ejb.Stateless;
import mdb.Mensaje;

/**
 * bean para la comunicaicon con web
 * @author DJMEDINA
 */
@Stateless
public class Jms implements JmsLocal {

    /**
     * metodo para envair mensaje al jms
     * @param mensaje 
     */
    @Override
    public void sendMessage(String mensaje) {
        System.out.println(mensaje);
        Mensaje mensajeBean = new Mensaje();
        mensajeBean.sendMessage(mensaje);
    }

    
    
}
