package com.kanha.ecommerce_sb.repository;

import com.kanha.ecommerce_sb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /*
    - This is our custom JPA method we have declared it, here we do not have to implement it.
    - Here we can use DSL[Domain Specific Language]. So we can use JPQL to define our query here by using @Query
    annotation.
    - SO whenever hit this particular method, it will execute the query, and whatever result we got, it will convert
    that into this object.
     */
    @Query("SELECT p from Product p WHERE " +
            " LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            " LOWER(p.productDescription) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            " LOWER(p.productBrand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            " LOWER(p.productCategory) LIKE LOWER(CONCAT('%', :keyword, '%')) " )
    List<Product> searchProducts(String keyword);
}

/*
Q: What is the difference between in SQL & JPQL?
Ans: Basically, we don't use table names, instead use class name, then use a certain JPA specific methods and syntax.
 */
