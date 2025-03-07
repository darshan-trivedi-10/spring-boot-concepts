package com.learning.spring_boot.scope.sessionscope;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    public final ShoppingCart shoppingCart;

    public CartController(ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    // This should be post but just for testing :)
    @GetMapping("/add/{item}")
    public String addItem(@PathVariable String item){
        shoppingCart.addItem(item);
        return "Item added : " + item;
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return shoppingCart.getItems();
    }

    // This should be delete but just for testing :)
    @GetMapping("/clear")
    public String clearCart(HttpSession session){
        session.invalidate();
        return "Cart cleared!";
    }
}
