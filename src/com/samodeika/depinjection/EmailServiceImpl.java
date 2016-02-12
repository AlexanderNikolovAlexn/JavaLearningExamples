package com.samodeika.depinjection;

public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Sending email to " + rec + " with message: " + msg);
    }
}
