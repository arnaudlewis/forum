package com.traveldoo.message.dto;

import com.traveldoo.message.Message;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by arnaud on 27/01/2014.
 */
@XmlType(name = "MessageResponseDTO")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResponseDTO {

    private List<Message> listMessage;

    public MessageResponseDTO() {
    }


    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }
}
