package com.igor.boot.fullstackApp.service;

import com.igor.boot.fullstackApp.entity.Debitoren;
import java.util.List;

public interface DebitorenService {
    List<Debitoren> getAllDebitoren();

    Debitoren saveDebitor(Debitoren debitoren);

    Debitoren getDebitor(int id);

    void updateDebitor(Debitoren existingDebitor);

    void deleteDebitor(int id);
}
