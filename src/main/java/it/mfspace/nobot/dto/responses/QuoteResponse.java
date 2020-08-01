package it.mfspace.nobot.dto.responses;

import it.mfspace.nobot.dto.NoBotConstants;

public class QuoteResponse extends BotResponse {

    private String text;
    private Long reply_to_message_id;

    public QuoteResponse() {
        this.setMethod(NoBotConstants.METHOD_SEND_MSG);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getReply_to_message_id() {
        return reply_to_message_id;
    }

    public void setReply_to_message_id(Long reply_to_message_id) {
        this.reply_to_message_id = reply_to_message_id;
    }
}
