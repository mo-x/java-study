package org.goskyer.use.mq.activitymq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zzqno on 2017-3-15.
 * 生产者
 */
public class Producer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL = "tcp://127.0.0.1:61616"; // 默认的连接地址
    private static final int SENDNUM = 10; // 发送的消息数量

    public static void main(String[] args) {
        ConnectionFactory connectionFactory; // 连接工厂
        Connection connection = null; // 连接
        Session session; // 会话 接受或者发送消息的线程
        Destination destination; // 消息的目的地
        MessageProducer messageProducer; // 消息生产者

        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(Producer.USERNAME, Producer.PASSWORD, Producer.BROKEURL);

        try {
            connection = connectionFactory.createConnection(); // 通过连接工厂获取连接
            connection.setClientID("XPS-15-zzq");
            connection.start(); // 启动连接
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); // 创建Session,第一个参数为是否开启事务
            Topic topic = session.createTopic("XPS-15-zzq.topic");
            TopicSubscriber subs = session.createDurableSubscriber(topic, "XPS-15-zzq.topic");

            subs.setMessageListener((Message message) -> {
                TextMessage tm = (TextMessage) message;
                try {
                    System.out.println("Received message: " + tm.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
