package it.mfspace.nobot.dto;

import java.util.Date;

public class Message {

    private Long message_id;
    private MessageDetail from;
    private Chat chat;
    private Date date;
    private String text;

    public Long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }

    public MessageDetail getFrom() {
        return from;
    }

    public void setFrom(MessageDetail from) {
        this.from = from;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
