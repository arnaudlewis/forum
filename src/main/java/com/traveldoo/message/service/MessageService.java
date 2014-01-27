package com.traveldoo.message.service;

import com.traveldoo.message.Message;
import com.traveldoo.message.dataAccess.DaoMessage;
import com.traveldoo.message.dto.MessageRequestDTO;
import com.traveldoo.message.dto.MessageResponseDTO;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */

@Path("message")
public class MessageService {

    @Path("/list")
    public MessageResponseDTO listAll(MessageRequestDTO request) {
        MessageResponseDTO response = new MessageResponseDTO();
        List<Message> liste = DaoMessage.getInstance().findAllBySubject(request.getSubject());

        response.setListMessage(liste);

        return response;
    }
}
