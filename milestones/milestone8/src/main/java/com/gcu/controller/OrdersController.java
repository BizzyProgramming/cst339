package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.model.CartItem;

/**
 * OrdersController
 *
 * Handles user order operations such as viewing the cart,
 * checking out, and displaying a success confirmation.
 * Currently, order persistence is simulated using session data.
 */
@Controller
public class OrdersController {

    /**
     * Displays the cart page showing all selected items.
     *
     * @param model   the model used to send attributes to the Thymeleaf view
     * @param session the HTTP session containing the current cart
     * @return the cart (orders) view template name
     */
    @GetMapping("/orders")
    public String showCart(Model model, HttpSession session) {
        List<CartItem> cart = getOrCreateCart(session);

        float totalPrice = 0f;
        int totalCoins = 0;
        for (CartItem ci : cart) {
            totalPrice += ci.getLinePrice();
            totalCoins += ci.getLineCoins();
        }

        model.addAttribute("title", "Your Cart");
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("totalCoins", totalCoins);

        return "orders"; // orders.html (cart/checkout page)
    }

    /**
     * Simulates the checkout process and clears the cart after completion.
     *
     * @param session the HTTP session containing the user's cart
     * @return a redirect to the order success confirmation page
     */
    @PostMapping("/orders/checkout")
    public String checkout(HttpSession session) {
        // Future enhancement: Persist orders to database
        session.setAttribute("cart", new ArrayList<CartItem>());
        return "redirect:/orders/success";
    }

    /**
     * Displays a confirmation message after a successful order.
     *
     * @param model the model used to send attributes to the Thymeleaf view
     * @return the success confirmation template name ("success.html")
     */
    @GetMapping("/orders/success")
    public String orderSuccess(Model model) {
        model.addAttribute("title", "Order Successful");
        return "success";
    }

    /**
     * Retrieves the existing cart from the session or creates a new one.
     *
     * @param session the HTTP session used to store the cart
     * @return the current or newly created list of cart items
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