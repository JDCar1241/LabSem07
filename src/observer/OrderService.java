package service;

import adapter.PaymentProcessor;
import observer.OrderObserver;
import strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private DiscountStrategy discountStrategy;
    private PaymentProcessor paymentProcessor;

    private List<OrderObserver> observers = new ArrayList<>();

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void processOrder(double total) {

        double finalTotal = discountStrategy.applyDiscount(total);

        paymentProcessor.pay(finalTotal);

        System.out.println("Compra confirmada por S/ " + finalTotal);

        notifyObservers();
    }

    private void notifyObservers() {

        for (OrderObserver observer : observers) {
            observer.update("Nueva compra realizada");
        }
    }
}