package ru.example.walletapplication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@Setter
public class WalletRequest {
    private UUID id;
    private BigDecimal amount;
}
