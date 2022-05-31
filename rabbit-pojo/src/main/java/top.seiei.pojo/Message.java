package top.seiei.pojo;

import top.seiei.enums.MessageType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// 消息体，使用 RabbitMQ 作为消息体时，需要实现序列化接口
public class Message implements Serializable {

    public Message() {
    }

    public Message(String messageId, String topic, String routingKey, Map<String, Object> attributes, int delayMills, int messageType) {
        this.messageId = messageId;
        this.topic = topic;
        this.routingKey = routingKey;
        this.attributes = attributes;
        this.delayMills = delayMills;
        this.messageType = messageType;
    }

    private static final long serialVersionUID = -6914719416632775939L;

    // 消息唯一 ID
    private String messageId;

    // 消息主题（exchange 的 topic）
    private String topic;

    // 消息路由 key
    private String routingKey = "";

    // 消息的附加属性
    private Map<String, Object> attributes = new HashMap<>();

    // 延迟发送时间（秒）
    private int delayMills;

    // 消息类型
    private int messageType = MessageType.CONFIRM.type;


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public int getDelayMills() {
        return delayMills;
    }

    public void setDelayMills(int delayMills) {
        this.delayMills = delayMills;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
