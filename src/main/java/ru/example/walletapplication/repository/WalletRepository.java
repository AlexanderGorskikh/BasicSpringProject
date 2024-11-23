package ru.example.walletapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.walletapplication.entity.Wallet;

import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
