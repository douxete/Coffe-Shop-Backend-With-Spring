package com.vnc.coffeshop.controller;

import com.vnc.coffeshop.entity.Coffee;
import com.vnc.coffeshop.service.CoffeService;
import com.vnc.coffeshop.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    CoffeService coffeService;

    @PostMapping
    public Coffee insertCoffee(@RequestBody Coffee coffee){
        return coffeService.addCoffee(coffee);
    }

//    @GetMapping
//    public List<Coffee> getAllCoffee(){
//        return coffeService.getAllCoffee();
//    }

    @GetMapping
    public PageResponseWrapper<Coffee> getCoffeePerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                                                        @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
                                                        @RequestParam(name = "direction", defaultValue = "ASC") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Coffee> coffeePage = coffeService.getCoffeePerPage(pageable);
        return new PageResponseWrapper<>(coffeePage);
    }

    @GetMapping("/search")
    public List<Coffee> searchCoffee(@RequestParam String name){
        return coffeService.searchCoffeeName(name);
    }

    @GetMapping("/{id}")
    public Coffee getCoffee(@PathVariable String id){
        return coffeService.getCoffeeById(id);
    }

    @PutMapping
    public Coffee updateCoffee(@RequestBody Coffee coffee){
        return coffeService.updateCoffee(coffee);
    }

    @DeleteMapping
    public void deleteCoffee(@RequestParam String id){
        coffeService.deleteCoffee(id);
    }
}
