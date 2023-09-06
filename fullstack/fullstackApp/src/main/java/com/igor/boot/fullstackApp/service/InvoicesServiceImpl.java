package com.igor.boot.fullstackApp.service;

import com.igor.boot.fullstackApp.entity.Invoices;
import com.igor.boot.fullstackApp.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoicesServiceImpl implements InvoiceService {

    @Autowired
    InvoicesRepository invoicesRepository;

    @Override
    public List<Invoices> getAllInvoices() {
        return invoicesRepository.findAll();
    }

    @Override
    public Invoices saveInvoice(Invoices invoices) {
        return invoicesRepository.save(invoices);
    }

    @Override
    public Invoices getInvoice(int id) {
        return invoicesRepository.findById(id).get();
    }

    @Override
    public void deleteInvoice(int id) {
        invoicesRepository.deleteById(id);
    }

    @Override
    public void updateInvoice(Invoices invoices) {
        if (invoicesRepository.existsById(invoices.getId())) {
            invoicesRepository.save(invoices);
        }
    }
}
