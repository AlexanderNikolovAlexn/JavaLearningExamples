package com.samodeika.depinjection.designpattern;

public class MyApplication {

    private EmailService email = new EmailService();

    public void proccessMessage(String msg, String rec) {
        System.out.println("Proccessing message!");
        this.email.sendEmail(msg, rec);
    }

}
