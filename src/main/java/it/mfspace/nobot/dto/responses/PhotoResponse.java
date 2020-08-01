package it.mfspace.nobot.dto.responses;

import it.mfspace.nobot.dto.NoBotConstants;

public class PhotoResponse extends BotResponse {

    private String photo;

    public PhotoResponse() {
        this.setMethod(NoBotConstants.METHOD_SEND_PHOTO);
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
