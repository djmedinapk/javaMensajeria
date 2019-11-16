/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.ejb.Local;

/**
 * intefaz de jms tipo local
 * @author DJMEDINA
 */
@Local
public interface JmsLocal {
 
    /**
     * metodo par enviar mensajes a la intefaz
     * @param mensaje 
     */
    public void sendMessage(String mensaje);
}
