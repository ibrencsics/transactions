package org.ib.transactions;

import org.ib.transactions.tests.EventHandler;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: ibrencsics
 * Date: 2012.12.13.
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("app-springContext.xml");

        // in case of using TransactionProxyFactoryBean, the proxy should be looked up
//        EventHandler eventHandler = (EventHandler) ctx.getBean("eventHandler");

        EventHandler eventHandler = (EventHandler) ctx.getBean("eventHandlerTarget");
        eventHandler.sendMessage();

//        System.exit(0);
    }
}
