package com.hibernate.models.proxy.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Bid_proxy {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected Item_proxy item;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected User_proxy bidder;

    @NotNull
    protected BigDecimal amount;

    public Bid_proxy() {
    }

    public Bid_proxy(Item_proxy item, User_proxy bidder, BigDecimal amount) {
        this.item = item;
        this.amount = amount;
        this.bidder = bidder;
    }

    public Long getId() {
        return id;
    }

    public Item_proxy getItem() {
        return item;
    }

    public void setItem(Item_proxy item) {
        this.item = item;
    }

    public User_proxy getBidder() {
        return bidder;
    }

    public void setBidder(User_proxy bidder) {
        this.bidder = bidder;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
