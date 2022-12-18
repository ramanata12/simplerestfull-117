/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum.SpringbootAplication;

import model.Product;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author MSi-GAMING
 */
@RestController
public class ProductServiceController {
       private static Map<String, Product> productRepo = new HashMap<>();
   static {
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      honey.setQty("1");
      honey.setPrice("Rp. 20000");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      almond.setQty("1");
      almond.setPrice("Rp. 15000");
      productRepo.put(almond.getId(), almond);
      
      Product chocolate = new Product();
      chocolate.setId("3");
      chocolate.setName("Chocolate");
      chocolate.setQty("1");
      chocolate.setPrice("12000");
      productRepo.put(chocolate.getId(), chocolate);
      
      Product milk = new Product();
      milk.setId("4");
      milk.setName("Milk");
      milk.setQty("1");
      milk.setPrice("6000");
      productRepo.put(milk.getId(), milk);
   }
   
   // DElETE API (method untuk menghapus produk) 
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      productRepo.remove(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   
   // PUT API (method untuk mengcreate pruduk)
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
       
       // validasi ID 
       if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Product id not found, please check again", HttpStatus.NOT_FOUND);
        }
       
       // validasi respom ID sukses di update
        else{
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new  ResponseEntity<>("Product is updated Successfully",HttpStatus.OK);
        }
        
    }
   
   // POST API (method untuk menambahkan data)
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
       
       // validasi ID
       if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("Product id cannot be the same, please check again", HttpStatus.OK);
        }
       
       // validasi respon ID sukses di buat
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created Successfully", HttpStatus.CREATED);
        }
    }
   
   // GET API
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}
