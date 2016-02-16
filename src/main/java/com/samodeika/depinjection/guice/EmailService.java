package com.samodeika.depinjection.guice;

public class EmailService implements MessageService {

    @Override
    public void sendMessage(String subject, String message) {
        System.out.printf("Email: %s, %s%n", subject, message);
    }
}
