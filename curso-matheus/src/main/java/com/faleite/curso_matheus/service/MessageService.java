package com.faleite.curso_matheus.service;

import com.faleite.curso_matheus.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public String getMessage(){
        return messageRepository.getMessage();
    }
}
