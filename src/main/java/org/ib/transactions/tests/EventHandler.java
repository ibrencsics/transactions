package org.ib.transactions.tests;

import org.ib.transactions.mysql.ExampleDAO;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ibrencsics
 * Date: 2012.12.13.
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
@Transactional(propagation = Propagation.REQUIRED)
public class EventHandler {

    private JmsTemplate jmsTemplate;
    private Queue queue;
    private Boolean fail;

    private ExampleDAO exampleDAO;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

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

    public void sendMessage() {

        getExampleDAO().insertTransactionTest(new Date().toString(), "sent");

        getJmsTemplate().send(getQueue(), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("Szeva");
            }
        });

        if (fail)
            throw new RuntimeException("!!!!!!!!!!!!! sender rollback");
    }
}
