package com.healthmgmt.app.entity.v2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthmgmt.app.entity.Product;



@Entity
@Table(name ="product")
public class MedProducts {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     //@NotNull(message = "Product name must not be null")
    // @NotEmpty
     @Column(name = "name", nullable = false)
     private String name;


//     @ManyToOne
//     @JoinColumn(name="category_id")
//     private Category category;

     @ManyToMany(mappedBy = "productlist")
     private List<OrderDetails> orderDetail =new ArrayList<OrderDetails>();
     
     public final static String product_ordered ="Select p from Product p Join p.orderDetail od Where od.id = :id";

//     @Query(product_ordered)
//     public List<Product> findById(@Param("id") int id);
     
}
