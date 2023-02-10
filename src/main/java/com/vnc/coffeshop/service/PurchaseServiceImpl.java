package com.vnc.coffeshop.service;

import com.vnc.coffeshop.entity.Purchase;
import com.vnc.coffeshop.entity.PurchaseDetail;
import com.vnc.coffeshop.repository.PurchaseDetailRepository;
import com.vnc.coffeshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Override
    public Purchase transaction(Purchase purchase) {
        Purchase purchase1= purchaseRepository.save(purchase);
        for (PurchaseDetail purchaseDetail : purchase1.getPurchaseDetails()) {
            purchaseDetail.setPurchase(purchase1);
            purchaseDetailService.savePurchaseDetail(purchaseDetail);
        }
        return purchase1;
    }
}
