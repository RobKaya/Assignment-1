package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3010")
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/carts/{id}")
    public List<CartItem> getCartContents(@PathVariable Integer id) {
        return cartService.getCart();
    }


    @PatchMapping("/carts/{id}")
    public ResponseEntity<HttpStatus> updateCart(@PathVariable int id, @RequestParam("action") String action, @RequestBody CartItem item) {
        switch (action) {
            case "add":
                cartService.addItem(item);
                return new ResponseEntity<>(HttpStatus.OK);
            case "remove":
                cartService.removeItem(item);
                return new ResponseEntity<>(HttpStatus.OK);
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<HttpStatus> clearCartContents(@PathVariable int id, @RequestParam(value = "buyout", required = false) boolean buyout) {
        cartService.clearCart(!buyout);
        //if (buyout == null || !buyout) {
        //    cartService.clearCart(true);
        //} else cartService.clearCart(false);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}