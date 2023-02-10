package com.vnc.coffeshop.repository;

import com.vnc.coffeshop.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, String> {
    List<Coffee> findCoffeeByNameContaining(String name);

}
