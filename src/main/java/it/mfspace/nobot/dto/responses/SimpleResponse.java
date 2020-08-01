package it.mfspace.nobot.dto.responses;

import it.mfspace.nobot.dto.NoBotConstants;

public class SimpleResponse extends BotResponse {

    private String text;

    public SimpleResponse() {
        this.setMethod(NoBotConstants.METHOD_SEND_MSG);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
