package com.igor.boot.fullstackApp.repository;

import com.igor.boot.fullstackApp.entity.Debitoren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitorenRepository extends JpaRepository<Debitoren, Integer> {
}
