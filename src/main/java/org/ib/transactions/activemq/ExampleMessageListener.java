package org.ib.transactions.activemq;

import org.ib.transactions.mysql.ExampleDAO;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ibrencsics
 * Date: 2012.12.12.
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
public class ExampleMessageListener implements MessageListener {

    private ExampleDAO exampleDAO;
    private Boolean fail;

    public ExampleDAO getExampleDAO() {
        return exampleDAO;
    }

    public void setExampleDAO(ExampleDAO exampleDAO) {
        this.exampleDAO = exampleDAO;
    }

    public Boolean getFail() {
        return fail;
    }

    public void setFail(Boolean fail) {
        this.fail = fail;
    }

    @Override
    public void onMessage(Message message) {

        try {
            String textMessage = ((TextMessage)message).getText();

            System.out.println("Received: " + textMessage);
            exampleDAO.insertTransactionTest(new Date().toString(), "received");

            if (fail)
                throw new RuntimeException("!!!!!!!!!!!!! receiver rollback");

        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
