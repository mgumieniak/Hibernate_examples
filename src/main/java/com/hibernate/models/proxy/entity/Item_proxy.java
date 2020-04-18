package com.hibernate.models.proxy.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item_proxy {
    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    protected String name;

    @NotNull
    protected Date auctionEnd;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected User_proxy seller;

    @OneToMany(mappedBy = "item")
//    @org.hibernate.annotations.BatchSize(size = 5) powoduje dodatkowe query
    @Fetch(
            FetchMode.SUBSELECT
    )
    protected Set<Bid_proxy> bids = new HashSet<>();

    public Item_proxy() {
    }

    public Item_proxy(String name, Date auctionEnd, User_proxy seller) {
        this.name = name;
        this.auctionEnd = auctionEnd;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public User_proxy getSeller() {
        return seller;
    }

    public void setSeller(User_proxy seller) {
        this.seller = seller;
    }

    public Set<Bid_proxy> getBids() {
        return bids;
    }

    public void setBids(Set<Bid_proxy> bids) {
        this.bids = bids;
    }

}
