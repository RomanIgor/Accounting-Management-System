package com.igor.boot.fullstackApp.service;


import com.igor.boot.fullstackApp.entity.Invoices;

import java.util.List;

public interface InvoiceService {
    List<Invoices> getAllInvoices();

    Invoices saveInvoice(Invoices invoices);

    Invoices getInvoice(int id);

    void deleteInvoice(int id);



//    void updateInvoice(Invoices invoices);

    void updateInvoice(Invoices existingInvoice);
}
