package org.goskyer.use.mq.activitymq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zzqno on 2017-3-15.
 */
public class MyListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("收到的消息：" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
