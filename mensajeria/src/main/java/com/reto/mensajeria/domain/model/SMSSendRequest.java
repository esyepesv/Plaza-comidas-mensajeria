package com.reto.mensajeria.domain.model;

import lombok.Data;

@Data
public class SMSSendRequest {
    private String destinationSMSNumber;
    private String smsMessage;

}
