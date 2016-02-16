package com.samodeika.depinjection.guice;

public class TweetService implements MessageService {

    @Override
    public void sendMessage(String subject, String message){
        System.out.printf("Tweet: %s, %s%n", subject, message);
    }

}
