package com.vnc.coffeshop.service;

import com.vnc.coffeshop.entity.Purchase;

public interface PurchaseService {
    Purchase transaction(Purchase purchase);
}
