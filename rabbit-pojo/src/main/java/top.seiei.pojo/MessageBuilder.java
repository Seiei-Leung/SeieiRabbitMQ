package top.seiei.pojo;

import top.seiei.enums.MessageType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Message 对象，建造者模式
 * 建造者模式默认的成员变量与想要建造返回的对象要一致
 */
public class MessageBuilder implements Serializable {

    private static final long serialVersionUID = 8086219469511158367L;
    private String messageId;
    private String topic;
    private String routingKey = "";
    private Map<String, Object> attributes = new HashMap<>();
    private int delayMills;
    private int messageType = MessageType.CONFIRM.type;

    // 隐藏构造函数
    private MessageBuilder() {}

    public MessageBuilder create() {
        return new MessageBuilder();
    }

    public MessageBuilder withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public MessageBuilder withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public MessageBuilder withRoutingKey(String routingKey) {
        this.routingKey = routingKey;
        return this;
    }

    public MessageBuilder withAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }

    public MessageBuilder withAttribute(String key, Object value) {
        this.attributes.put(key, value);
        return this;
    }

    public MessageBuilder withDelayMills(int delayMills) {
        this.delayMills = delayMills;
        return this;
    }

    public MessageBuilder widthMessageType(int messageType) {
        this.messageType = messageType;
        return this;
    }

    public Message build() {
        if (messageId == null) {
            messageId = UUID.randomUUID().toString();
        }
        if (topic == null) {
            throw new RuntimeException("topic 不能为 null");
        }
        return new Message(messageId, topic, routingKey, attributes, delayMills, messageType);
    }
}
