package com.clps.jPet.domain;



/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart  implements java.io.Serializable {


    // Fields    

     private long id;
     private Item item;
     private Signon signon;
     private Integer quantity;


    // Constructors

    /** default constructor */
    public Cart() {
    }

    
    /** full constructor */
    public Cart(Item item, Signon signon, Integer quantity) {
        this.item = item;
        this.signon = signon;
        this.quantity = quantity;
    }

   
    // Property accessors

    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }

    public Signon getSignon() {
        return this.signon;
    }
    
    public void setSignon(Signon signon) {
        this.signon = signon;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
   








}