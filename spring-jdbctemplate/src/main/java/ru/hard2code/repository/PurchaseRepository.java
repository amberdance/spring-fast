package ru.hard2code.repository;

import ru.hard2code.model.Purchase;

import java.util.List;

public interface PurchaseRepository {

    void storePurchase(Purchase purchase);

    List<Purchase> findAll();
}
