/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * message driver bean
 * @author DJMEDINA
 */
@MessageDriven(mappedName = "lineaTest", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class DriverBean implements MessageListener {

    /**
     * constructor
     */
    public DriverBean() {
    }

    /**
     * se dispara cuando recibe un menaje
     * @param message 
     */
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            if (textMessage != null) {
                System.out.println("Mensaje Recibido: "+textMessage.getText());
            }
        } catch (JMSException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
