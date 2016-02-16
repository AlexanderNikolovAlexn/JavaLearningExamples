package com.samodeika.depinjection.guice;

public class FastEmailService implements MessageService {

    @Override
    public void sendMessage(String subject, String message) {
        System.out.printf("Fast Email: %s, %s%n", subject, message);
    }
}
