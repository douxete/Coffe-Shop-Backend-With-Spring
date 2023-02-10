package com.vnc.coffeshop.service;

import com.vnc.coffeshop.entity.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoffeService {
    public Coffee addCoffee(Coffee coffee);
    public Coffee getCoffeeById(String id);
    public List<Coffee> getAllCoffee();
    public Coffee updateCoffee(Coffee coffee);
    public void  deleteCoffee(String id);
    public Page<Coffee> getCoffeePerPage(Pageable pageable);
    List<Coffee> searchCoffeeName(String name);
}
