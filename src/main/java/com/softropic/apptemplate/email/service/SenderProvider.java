package com.softropic.apptemplate.email.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public interface SenderProvider {
    JavaMailSenderImpl nextSender();
}
