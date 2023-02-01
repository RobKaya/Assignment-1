package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3010")
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getAllProductsInCategory(@PathVariable String id) {


        if (id.matches("^\\d+$")) {
            try {
                Product product = productService.getProductById(Integer.parseInt(id));
                if (product == null) {
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(product, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                List<Product> products = productService.getAllProductsInCategory(id);
                return new ResponseEntity<>(products, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    }

}

