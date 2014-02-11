package com.traveldoo.message.service;

import com.traveldoo.message.Message;
import com.traveldoo.message.dataAccess.DaoMessage;
import com.traveldoo.message.dto.MessageCreateRequestDTO;
import com.traveldoo.message.dto.MessageCreateResponseDTO;
import com.traveldoo.message.dto.MessageRequestDTO;
import com.traveldoo.message.dto.MessageResponseDTO;
import com.traveldoo.subject.Subject;
import com.traveldoo.subject.dataAccess.DaoSubject;
import com.traveldoo.user.dataAccess.DaoUser;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by arnaud on 27/01/2014.
 */

@Path("message")
public class MessageService {

    @POST
    @Path("/create")
    public MessageCreateResponseDTO createMessage(MessageCreateRequestDTO request) {
        MessageCreateResponseDTO response = new MessageCreateResponseDTO();
        Message msg = new Message();
        msg.setAuthor(DaoUser.getInstance().find(request.getId_author()));
        msg.setContent(request.getContent());
        msg.setCreation_date(request.getCreationDate());
        msg.setTitle(request.getTitle());
        msg.setSubject(request.getSubject());

        response.setId_message(DaoMessage.getInstance().insert(msg));
        Subject sub = DaoSubject.getInstance().find(request.getSubject().getId_subject());
        sub.getMessageList().add(msg);
        response.setSubject(sub);

        return response;
    }
}
