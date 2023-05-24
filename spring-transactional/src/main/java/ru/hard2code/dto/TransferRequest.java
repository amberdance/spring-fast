package ru.hard2code.dto;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Data
public class TransferRequest {

    long senderAccountId;
    long receiverAccountId;
    BigDecimal amount;
}
