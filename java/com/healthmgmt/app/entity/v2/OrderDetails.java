package com.healthmgmt.app.entity.v2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.healthmgmt.app.entity.Appuser;
import com.healthmgmt.app.entity.Product;

@Entity
@Table(name = "order_detail")
public class OrderDetails {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;


     @ManyToOne
     @JoinColumn(name="username")
     private Appuser PurchasedBy;


     @ManyToMany
     @JoinTable(
       name="order_detail_productlist",
       joinColumns=@JoinColumn(name="order_detail_id", referencedColumnName="id"),
       inverseJoinColumns=@JoinColumn(name="productlist_id", referencedColumnName="id"))
      private Set<Product> productlist = new HashSet<Product>();
     
     
     
    
     
}
