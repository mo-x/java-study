package org.xinyu.use.mq.activitymq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zzqno on 2017-3-15.
 */
public class JMSConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL = "tcp://192.168.159.128:61616";// 默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory; // 连接工厂
        Connection connection; // 连接
        Session session; // 会话 接受或者发送消息的线程
        Destination destination; // 消息的目的地
        MessageConsumer messageConsumer;// 消息消费者

        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);

        try {
            connection = connectionFactory.createConnection();// 通过工厂获取连接
            connection.start();// 启动连接
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);// 第一个参数为是否开启事务
            destination = session.createQueue("FirstQueue1");// 创建消息队列
            messageConsumer = session.createConsumer(destination);// 创建消息消费者
            /*
             * 实际应用中，不会这么用，会注册一个监听
             */
          /*  while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
                if (textMessage != null) {
                    System.out.println("收到的消息：" + textMessage.getText());
                } else {
                    break;
                }
            }*/
            messageConsumer.setMessageListener(new MyListener());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
