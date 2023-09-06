package com.igor.boot.fullstackApp.service;

import com.igor.boot.fullstackApp.entity.Debitoren;
import com.igor.boot.fullstackApp.repository.DebitorenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitorenServiceImpl implements DebitorenService {
    @Autowired
    DebitorenRepository debitorenRepository;
    @Override
    public List<Debitoren> getAllDebitoren() {
        return debitorenRepository.findAll();
    }

    @Override
    public Debitoren saveDebitor(Debitoren debitoren) {
        return debitorenRepository.save(debitoren);
    }

    @Override
    public Debitoren getDebitor(int id) {
        return debitorenRepository.findById(id).get();
    }

    @Override
    public void updateDebitor(Debitoren debitor) {
        if(debitorenRepository.existsById(debitor.getId()))
            debitorenRepository.save(debitor);
    }
    @Override
    public void deleteDebitor(int id) {
        debitorenRepository.deleteById(id);
    }

}
