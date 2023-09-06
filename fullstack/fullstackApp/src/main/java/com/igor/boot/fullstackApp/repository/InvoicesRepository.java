package com.igor.boot.fullstackApp.repository;


import com.igor.boot.fullstackApp.entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoicesRepository extends JpaRepository<Invoices, Integer> {

    List<Invoices> findInvoiceById(int id);
}
