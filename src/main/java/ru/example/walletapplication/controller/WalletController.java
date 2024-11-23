package ru.example.walletapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.walletapplication.dto.WalletRequest;
import ru.example.walletapplication.dto.WalletResponse;
import ru.example.walletapplication.entity.Wallet;
import ru.example.walletapplication.service.WalletService;

@RestController
@RequestMapping("api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping()
    public ResponseEntity<?> createWallet() {
        Wallet wallet = walletService.createWallet();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(WalletResponse.builder()
                        .id(wallet.getId())
                        .balance(wallet.getBalance())
                        .build());
    }

    @GetMapping("transaction")
    public ResponseEntity<?> getBalance(@RequestBody WalletRequest request) {
        Wallet wallet = walletService.getWallet(request.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(WalletResponse.builder()
                                .id(wallet.getId())
                                .balance(wallet.getBalance())
                                .build()
                );
    }

    @PostMapping("transaction/deposit")
    public ResponseEntity<?> deposit(@RequestBody WalletRequest request) {
        Wallet wallet = walletService.deposit(request.getId(), request.getAmount());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(WalletResponse.builder()
                        .balance(wallet.getBalance())
                        .build());
    }

    @PostMapping("transaction/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WalletRequest request) {
        Wallet wallet = walletService.withdraw(request.getId(), request.getAmount());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(WalletResponse.builder()
                        .balance(wallet.getBalance())
                        .build());
    }
}
