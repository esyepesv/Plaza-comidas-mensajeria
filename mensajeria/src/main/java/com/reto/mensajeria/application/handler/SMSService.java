package com.reto.mensajeria.application.handler;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    @PostConstruct
    private void setup(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    public String sendSMS(String number, String smsMessage){

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+number),
                new com.twilio.type.PhoneNumber("whatsapp:"+OUTGOING_SMS_NUMBER),
                smsMessage
        ).create();

        return message.getStatus().toString();
    }
}
