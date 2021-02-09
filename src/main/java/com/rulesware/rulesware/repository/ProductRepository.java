package com.rulesware.rulesware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rulesware.rulesware.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
