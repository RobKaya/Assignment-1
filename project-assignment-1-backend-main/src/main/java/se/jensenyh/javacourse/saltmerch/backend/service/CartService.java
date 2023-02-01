package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public List<CartItem> getCart() {
        return cartRepository.selectAllItems();
    }

    public void addItem(CartItem item) {
        cartRepository.insertOrIncrementItem(item);
    }

    public void removeItem(CartItem item) {
        cartRepository.deleteOrDecrementItem(item);
    }

    public void clearCart(boolean restock) {
        cartRepository.deleteAllItems(restock);
    }
}


