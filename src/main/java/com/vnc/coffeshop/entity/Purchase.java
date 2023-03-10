package com.vnc.coffeshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trx_purchase")
public class Purchase {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "transaction_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private Double grandTotal;

    @OneToMany(mappedBy = "purchase")
    @JsonIgnoreProperties("purchase")
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();

    public Purchase() {
    }

    public Purchase(String id, Date purchaseDate, Member member, Double grandTotal) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.member = member;
        this.grandTotal = grandTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Member getMembers() {
        return member;
    }

    public void setMembers(Member member) {
        this.member = member;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }
}
