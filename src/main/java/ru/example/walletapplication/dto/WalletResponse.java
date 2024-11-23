package ru.example.walletapplication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class WalletResponse {
    private UUID id;
    private BigDecimal balance;
}
