package com.dummy.rest.stock.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true) 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)     
    //@Email
    private String username; // # email    

    @Column(nullable = false, updatable = false) 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String firstname;

    private String lastname;
    
    
    // ! Important Properties
    private String role;
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked; 
    

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    // address_id +. column name address_id in USER TABLE
    private Address address;
    
}
