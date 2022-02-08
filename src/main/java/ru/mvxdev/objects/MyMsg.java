package ru.mvxdev.objects;

public class MyMsg {

    private String MessageID;
    private String CorrelationID;
    private String Destination;
    private String ReplyTo;
    private int Priority = 4;
    private int DeliveryMode = 2;
    private long Expiration = 0;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessageID() {
        return MessageID;
    }

    public void setMessageID(String messageID) {
        MessageID = messageID;
    }

    public String getCorrelationID() {
        return CorrelationID;
    }

    public void setCorrelationID(String correlationID) {
        CorrelationID = correlationID;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getReplyTo() {
        return ReplyTo;
    }

    public void setReplyTo(String replyTo) {
        ReplyTo = replyTo;
    }

    public long getExpiration() {
        return Expiration;
    }

    public void setExpiration(long expiration) {
        Expiration = expiration;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public int getDeliveryMode() {
        return DeliveryMode;
    }

    public void setDeliveryMode(int deliveryMode) {
        DeliveryMode = deliveryMode;
    }

    public MyMsg(){

    };

    @Override
    public String toString() {
        return "MyMsg{" +
                "MessageID='" + MessageID + '\'' +
                ", CorrelationID='" + CorrelationID + '\'' +
                ", Destination='" + Destination + '\'' +
                ", ReplyTo='" + ReplyTo + '\'' +
                ", Priority=" + Priority +
                ", DeliveryMode=" + DeliveryMode +
                ", Expiration=" + Expiration +
                ", data='" + data + '\'' +
                '}';
    }
}
