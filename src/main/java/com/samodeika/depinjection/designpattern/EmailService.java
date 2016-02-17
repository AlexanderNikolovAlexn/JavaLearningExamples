package com.samodeika.depinjection.designpattern;

public class EmailService {

    public void sendEmail(String message, String receiver) {
        System.out.println("Sending email to " + receiver + " with message: " + message);
    }

}
