package com.samodeika.depinjection.guice;

public class SmsService implements MessageService {

    @Override
    public void sendMessage(String subject, String message){
        System.out.printf("SMS: %s, %s%n", subject, message);
    }

}