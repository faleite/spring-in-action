package com.faleite.curso_matheus.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    public String getMessage(){
        return "Hello from repository";
    }
}
