package com.samodeika.depinjection.designpattern;

public class SMSServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Sending SMS to " + rec + " with message: " + msg);
    }
}
