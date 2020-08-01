package it.mfspace.nobot.controller;

import it.mfspace.nobot.dto.*;
import it.mfspace.nobot.dto.responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class NoBotController {

    Logger logger = Logger.getLogger("NoBotController");

    @GetMapping(value = "/check")
    public ResponseEntity<String> check() {
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/webhook")
    public ResponseEntity<BotResponse> webhook(@RequestBody Update update) {

        BotResponse res = null;
        ResponseEntity<BotResponse> response = null;
        Message message = update.getMessage();
        String msg = null;
        Long chatId = null;
        Long messageToReplyId = null;

        try {

            msg = message.getText();
            chatId = message.getChat().getId();
            messageToReplyId = message.getMessage_id();

            if(msg.equalsIgnoreCase("No")) {
                res = createQuoteResponse(chatId, "Molto bene", messageToReplyId);
            } else if(msg.toLowerCase().contains("illumino di immenso?")){
                res = createQuoteResponse(chatId, "https://www.youtube.com/watch?v=ras2dDmogzA", messageToReplyId);
            } else if(msg.toLowerCase().contains("la donzelletta vien dalla campagna?")){
                res = createQuoteResponse(chatId, "https://www.youtube.com/watch?v=vDhpXcpFEXg", messageToReplyId);
            } else if(msg.toLowerCase().contains("ciao") && (msg.toLowerCase().contains("nobot") || msg.toLowerCase().contains("no-bot"))) {
                res = createQuoteResponse(chatId, "Salve salviNo", messageToReplyId);
            } else if(msg.toLowerCase().contains("torinese") || msg.toLowerCase().contains("torinesi")) {
                res = createQuoteResponse(chatId, "Nè", messageToReplyId);
            } else if(msg.toLowerCase().contains("quelo")){
                res = createQuoteResponse(chatId, "La risposta è dentro di te. Che però è sbagliata.", messageToReplyId);
            } else if(msg.toLowerCase().contains("sai dire solo no?")){
                res = createQuoteResponse(chatId, "Si :)", messageToReplyId);
            } else if(msg.toLowerCase().contains("fuori dal letto")) {
                res = createQuoteResponse(chatId, "Nessuna pietà", messageToReplyId);
            } else if(msg.toLowerCase().contains("robin hood")) {
                res = createQuoteResponse(chatId, "E Little Tony", messageToReplyId);
            } else if(msg.toLowerCase().contains("azkaban")) {
                res = createQuoteResponse(chatId, "Si dice AXkaban!", messageToReplyId);
            } else if(msg.toLowerCase().contains("spezzare") && msg.toLowerCase().contains("tensione")) {
                res = createSimpleResponse(chatId, "AMMACCABANANE!");
            } else if((msg.toLowerCase().contains("piace") || msg.toLowerCase().contains("vuoi")) && msg.toLowerCase().contains("avocado")) {
                res = createPhotoQuoteResponse(chatId, "https://i.imgflip.com/2yxdnq.png", messageToReplyId);
            } else if(msg.toLowerCase().contains("avocado")) {
                res = createQuoteResponse(chatId, "Che schifo l'avocado", messageToReplyId);
            } else if(msg.toLowerCase().contains("domanda") || msg.toLowerCase().contains("domande")) {
                res = createSimpleResponse(chatId, "Ad ogni domanda c'è solo una risposta");
            } else if(msg.contains("?") && !msg.toLowerCase().contains("http")) {
                res = createSimpleResponse(chatId, "No");
            } else if(msg.equals("❓") || msg.equals("❔")) {
                res = createQuoteResponse(chatId, "Oh fermi tutti è arrivato l'haker...\n\n\n...No", messageToReplyId);
            }

            response = ResponseEntity.status(HttpStatus.OK).body(res);

        } catch(Exception e) {

            logger.warning( "Error with msg: " + msg);
            response =  ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }

        return response;
    }

    private BotResponse createSimpleResponse(Long chatId, String responseText) {
        SimpleResponse response = new SimpleResponse();
        response.setChat_id(chatId);
        response.setText(responseText);

        return response;
    }

    private BotResponse createQuoteResponse(Long chatId, String responseText, Long messageIdToReply) {
        QuoteResponse response = new QuoteResponse();
        response.setChat_id(chatId);
        response.setText(responseText);
        response.setReply_to_message_id(messageIdToReply);

        return response;
    }

    private BotResponse createPhotoResponse(Long chatId, String imgUrl) {
        PhotoResponse response = new PhotoResponse();
        response.setChat_id(chatId);
        response.setPhoto(imgUrl);

        return response;
    }

    private BotResponse createPhotoQuoteResponse(Long chatId, String imgUrl, Long messageIdToReply) {
        PhotoQuoteResponse response = new PhotoQuoteResponse();
        response.setChat_id(chatId);
        response.setPhoto(imgUrl);
        response.setReply_to_message_id(messageIdToReply);
        return response;
    }

}
