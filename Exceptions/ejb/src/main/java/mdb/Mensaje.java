/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author DJMEDINA
 */
public class Mensaje {

    /**
     * funcion crear mensaje publica 
     * @param mnessage 
     */
    public void sendMessage(String mnessage) {
        try {
            this.sendJMSMessageToLineaTest(mnessage);
        } catch (JMSException ex) {
            Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * metod crearnun mensaje apra lineatest recibe una session y un objeto yd evelve el mensaje para ser enviado al resource
     * @param session
     * @param messageData
     * @return
     * @throws JMSException 
     */
    private Message createJMSMessageForlineaTest(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    /**
     * metodo pra enviar un mensaje al resorce de jms
     * @param messageData
     * @throws JMSException
     * @throws NamingException 
     */
    private void sendJMSMessageToLineaTest(Object messageData) throws JMSException, NamingException {
        try {
            InitialContext context = new InitialContext();

            QueueConnectionFactory cF
                    = (QueueConnectionFactory) context.lookup("myCon");
            Queue queue = (Queue) context.lookup("lineaTest");

            Connection cnn = cF.createConnection();
            Session sess = cnn.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            MessageProducer messProd
                    = sess.createProducer(queue);

            messProd.send(createJMSMessageForlineaTest(sess, messageData));
            messProd.close();
            sess.close();
            cnn.close();
            System.out.println("El mensaje se envio correctamente");

        } catch (Exception e) {
             System.out.println("No fue posible enviar el mensaje:"+e.getMessage());
         }
    }
    
    
}
