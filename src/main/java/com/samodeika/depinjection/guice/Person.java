package com.samodeika.depinjection.guice;

import com.google.inject.Inject;

public class Person {
    private MessageService messageService;

    @Inject
    public Person(MessageService messageService){
        this.messageService = messageService;
    }

    public void greetFriend(){
        messageService.sendMessage("Hello", "Hello my friend :)");
    }
}
