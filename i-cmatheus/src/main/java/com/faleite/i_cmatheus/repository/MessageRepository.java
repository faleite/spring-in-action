package com.faleite.i_cmatheus.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    public String getMessage(){
        return "Hello from repository";
    }
}
