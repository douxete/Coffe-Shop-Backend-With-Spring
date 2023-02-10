package com.vnc.coffeshop.service;

import com.vnc.coffeshop.entity.Coffee;
import com.vnc.coffeshop.exception.DataNotFoundException;
import com.vnc.coffeshop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeService{

    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    public Coffee addCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @Override
    public Coffee getCoffeeById(String id) {
        verify(id);
        return coffeeRepository.findById(id).get();
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee updateCoffee(Coffee coffee) {
        verify(coffee.getId());
        return coffeeRepository.save(coffee);
    }

    @Override
    public void deleteCoffee(String id) {
        verify(id);
        coffeeRepository.deleteById(id);
    }

    @Override
    public Page<Coffee> getCoffeePerPage(Pageable pageable) {
        return coffeeRepository.findAll(pageable);
    }

    @Override
    public List<Coffee> searchCoffeeName(String name) {
        return coffeeRepository.findCoffeeByNameContaining(name);
    }

    public void verify(String id){
        if(!coffeeRepository.findById(id).isPresent()){
            String message = "Coffee not found";
            throw new DataNotFoundException(message);
        }
    }


}
