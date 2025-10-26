package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.CartItem;
import com.gcu.model.OrderModel;

/**
 * ShopController
 *
 * Displays products available for purchase and manages "Add to Cart" functionality.
 * This controller allows users to browse items and store their selections
 * in a session-based shopping cart.
 */
@Controller
public class ShopController {

    @Autowired
    private ProductBusinessInterface productBusinessService;

    /**
     * Displays all products available in the shop along with a cart summary.
     *
     * @param model   the model used to pass data to the Thymeleaf template
     * @param session the current HTTP session for managing the shopping cart
     * @return the name of the view template ("shop.html")
     */
    @GetMapping("/shop")
    public String showShopItems(Model model, HttpSession session) {
        List<OrderModel> products = productBusinessService.getAllProducts();
        model.addAttribute("title", "Shop Items");
        model.addAttribute("products", products);

        // Ensure cart exists
        List<CartItem> cart = getOrCreateCart(session);

        // Calculate totals
        float totalPrice = 0f;
        int totalCoins = 0;
        for (CartItem ci : cart) {
            totalPrice += ci.getLinePrice();
            totalCoins += ci.getLineCoins();
        }

        model.addAttribute("cartTotalPrice", totalPrice);
        model.addAttribute("cartTotalCoins", totalCoins);

        return "shop";
    }

    /**
     * Adds a product to the cart with the specified quantity.
     *
     * @param id       the ID of the product being added
     * @param quantity the number of items to add (must be ≥ 1)
     * @param session  the HTTP session to store the cart
     * @return a redirect back to the shop page
     */
    @PostMapping("/shop/add")
    public String addToCart(@RequestParam("id") int id,
                            @RequestParam("quantity") int quantity,
                            HttpSession session) {

        if (quantity < 1) quantity = 1;

        OrderModel product = productBusinessService.getProductById(id);
        if (product != null) {
            List<CartItem> cart = getOrCreateCart(session);

            CartItem existing = cart.stream()
                    .filter(ci -> ci.getProductId() == id)
                    .findFirst()
                    .orElse(null);

            if (existing == null) {
                CartItem ci = new CartItem(
                        product.getId(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getQuantity(),
                        quantity
                );
                cart.add(ci);
            } else {
                existing.setQuantity(existing.getQuantity() + quantity);
            }

            session.setAttribute("cart", cart);
        }

        return "redirect:/shop";
    }

    /**
     * Retrieves the cart from the session or creates a new one if none exists.
     *
     * @param session the HTTP session
     * @return the existing or new list of {@link CartItem}
     */
    @SuppressWarnings("unchecked")
    private List<CartItem> getOrCreateCart(HttpSession session) {
        Object obj = session.getAttribute("cart");
        if (obj == null) {
            List<CartItem> cart = new ArrayList<>();
            session.setAttribute("cart", cart);
            return cart;
        }
        return (List<CartItem>) obj;
    }
}