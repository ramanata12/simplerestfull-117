/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSi-GAMING
 */
public class Product {
   private String id;
   private String name;
   private String qty;
   private String price;

   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   
    public String getQty() {
        return qty;
    }

    public void setQty(String name) {
        this.qty = name;
    }

     public String getPrice() {
        return price;
    }

    public void setPrice(String name) {
        this.price = name;
    }
}
