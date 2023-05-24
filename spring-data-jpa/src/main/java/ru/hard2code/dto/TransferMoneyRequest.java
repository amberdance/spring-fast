package ru.hard2code.dto;


import lombok.Value;

import java.math.BigDecimal;

@Value
public class TransferMoneyRequest {

    long senderId;
    long receiverId;
    BigDecimal amount;

}
