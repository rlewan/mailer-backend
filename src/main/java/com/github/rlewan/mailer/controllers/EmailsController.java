package com.github.rlewan.mailer.controllers;

import com.github.rlewan.mailer.services.EmailService;
import com.github.rlewan.mailer.model.SendEmailRequest;
import com.github.rlewan.mailer.model.SendEmailResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api
@RestController
@RequestMapping(
    value = "/emails",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class EmailsController {

    private final EmailService emailService;

    @Autowired
    public EmailsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public SendEmailResponse sendEmail(@Valid @RequestBody SendEmailRequest request) {
        emailService.sendEmail(request);
        return SendEmailResponse.SUCCESS;
    }

}