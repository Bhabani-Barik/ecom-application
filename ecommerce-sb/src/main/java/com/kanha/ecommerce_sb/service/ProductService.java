package com.kanha.ecommerce_sb.service;

import com.kanha.ecommerce_sb.model.Product;
import com.kanha.ecommerce_sb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {

        /* Different Way of Handling this:  */
        return productRepository.findById(id).orElse(new Product()); // if data is not there , it return blank object

        /* another way, becuase we're handled it on Controller layer. */
        //return  productRepository.findById(id).get();

        /* for checking controller layer condition */
        // return  productRepository.findById(id).orElse(null);
    }

    //Add Product & product image
  /*  public Product addProduct(Product product, MultipartFile image) throws IOException {

        product.setProductImageName(image.getOriginalFilename());
        product.setProductImageType(image.getContentType());
        product.setProductImageData(image.getBytes());
        return productRepository.save(product);
    }*/

    // Update Product & Product Image
  /*  public Product updateProduct(Product product, MultipartFile image) throws IOException {
        product.setProductImageName(image.getOriginalFilename());
        product.setProductImageType(image.getContentType());
        product.setProductImageData(image.getBytes());
        return productRepository.save(product);
    }*/

    /* Add & Update perform in one method*/
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {

        product.setProductImageName(image.getOriginalFilename());
        product.setProductImageType(image.getContentType());
        product.setProductImageData(image.getBytes());
        return productRepository.save(product);
    }

    // Delete the product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    // Search Product
    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
