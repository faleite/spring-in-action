package com.faleite.i_cmatheus.service;

import com.faleite.i_cmatheus.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String getMessageRepository() {
        return messageRepository.getMessage();
    }
}
