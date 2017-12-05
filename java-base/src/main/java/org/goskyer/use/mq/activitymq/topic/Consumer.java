package org.goskyer.use.mq.activitymq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zzqno on 2017-3-15.
 * 消费者
 */
public class Consumer {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        factory.setDispatchAsync(false);//异步发送
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        /**
         Session javax.jms.Connection.createSession(boolean transacted, int acknowledgeMode) throws JMSException
         1.transacted事务，事务成功commit,才会将消息发送到mom中
         2.acknowledgeMode消息确认机制
         1）、带事务的session
         如果session带有事务，并且事务成功提交，则消息被自动签收。如果事务回滚，则消息会被再次传送。
         2）、不带事务的session
         不带事务的session的签收方式，取决于session的配置。
         Activemq支持一下三種模式：
         Session.AUTO_ACKNOWLEDGE  消息自动签收
         Session.CLIENT_ACKNOWLEDGE  客戶端调用acknowledge方法手动签收
         Session.DUPS_OK_ACKNOWLEDGE 不是必须签收，消息可能会重复发送。在第二次重新传送消息的时候，消息
         头的JmsDelivered会被置为true标示当前消息已经传送过一次，客户端需要进行消息的重复处理控制。
         代码示例如下：
         session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
         textMsg.acknowledge();
         */
        Topic topic = session.createTopic("XPS-15-zzq.topic");
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//设置非持久化
//          producer.setTimeToLive(5000);//5秒后过期，这个对点对点模式有效
        TextMessage message = session.createTextMessage();
        message.setText("message_" + System.currentTimeMillis());
        producer.send(message);
        System.out.println("Sent message: " + message.getText());
        session.close();
        connection.stop();
        connection.close();
    }
}
