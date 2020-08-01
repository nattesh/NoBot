package it.mfspace.nobot.dto.responses;

import it.mfspace.nobot.dto.NoBotConstants;

public class PhotoQuoteResponse extends BotResponse {

    private String photo;
    private Long reply_to_message_id;

    public PhotoQuoteResponse() {
        this.setMethod(NoBotConstants.METHOD_SEND_PHOTO);
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getReply_to_message_id() {
        return reply_to_message_id;
    }

    public void setReply_to_message_id(Long reply_to_message_id) {
        this.reply_to_message_id = reply_to_message_id;
    }
}
