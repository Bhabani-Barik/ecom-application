package com.kanha.ecommerce_sb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDescription;
    private String productBrand;
    private BigDecimal productPrice;
    private String productCategory;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private Date productReleaseDate;
    private boolean isProductAvailable;
    private int productStockQuantity;
    //Image
    private String productImageName;
    private String productImageType;
    @Lob //Large Object
    private byte[] productImageData; // actual image data

}
