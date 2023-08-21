package com.reto.mensajeria.infrastructure.input.rest;

import com.reto.mensajeria.application.handler.SMSService;
import com.reto.mensajeria.domain.model.SMSSendRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
@Slf4j
public class SMSRestController {

    @Autowired
    SMSService smsService;

    @PostMapping("/process")
    public String process(@RequestBody SMSSendRequest sendRequest){
        log.info("processSMS Started sendRequest:"+sendRequest.toString());
        return smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessage());
    }

}
