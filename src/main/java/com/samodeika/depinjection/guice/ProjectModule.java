package com.samodeika.depinjection.guice;

import com.google.inject.AbstractModule;

public class ProjectModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailService.class);
    }
}
