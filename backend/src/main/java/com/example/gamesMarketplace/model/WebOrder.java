
package com.example.gamesMarketplace.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Order generated from the website.
 */
@Entity
@Table(name = "web_order")
public class WebOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<WebOrderQuantities> quantities = new ArrayList<>();


    public List<WebOrderQuantities> getQuantities() {
        return quantities;
    }


    public void setQuantities(List<WebOrderQuantities> quantities) {
        this.quantities = quantities;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public AppUser getUser() {
        return user;
    }


    public void setUser(AppUser user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}