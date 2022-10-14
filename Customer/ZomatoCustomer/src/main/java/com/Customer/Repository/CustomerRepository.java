package com.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
