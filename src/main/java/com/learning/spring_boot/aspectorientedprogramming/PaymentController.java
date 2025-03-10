package com.learning.spring_boot.aspectorientedprogramming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/process")
    public String processPayment(@RequestParam String userName, @RequestParam double amount){
        paymentService.processPayment(userName, amount);
        return "Payment processed successfully!";
    }

    @GetMapping("/refund")
    public String refundPayment(@RequestParam String userName, @RequestParam double amount){
        paymentService.refundPayment(userName, amount);
        return "Payment refunded successfully!";
    }

    @GetMapping("/simulateError")
    public String simulateError(@RequestParam String username) {
        try {
            paymentService.simulateError(username);
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
        return "This won't be reached";
    }


}
