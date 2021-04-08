package org.xinyu.use.mq.rabbitmq;

import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * 生产者
 */
public class Producer extends EndPoint {
    public Producer(String endpointName) throws IOException {
        super(endpointName);
    }

    /**
     * 发送消息
     * @param object
     * @throws IOException
     */
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));

    }
}
