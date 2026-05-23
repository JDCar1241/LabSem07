import adapter.*;
import model.Cart;
import model.Product;
import observer.*;
import service.OrderService;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        // Crear productos
        Product p1 = new Product("Laptop", 2500);
        Product p2 = new Product("Mouse", 100);

        // Carrito
        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);

        double total = cart.calculateTotal();

        // Servicio de orden
        OrderService orderService = new OrderService();

        // Strategy
        orderService.setDiscountStrategy(
                new PercentageDiscountStrategy(10)
        );

        // Adapter
        ExternalPayPalService payPal = new ExternalPayPalService();

        orderService.setPaymentProcessor(
                new PayPalAdapter(payPal)
        );

        // Observer
        orderService.addObserver(
                new EmailNotificationObserver()
        );

        orderService.addObserver(
                new InventoryObserver()
        );

        orderService.addObserver(
                new AdminNotificationObserver()
        );

        // Procesar compra
        orderService.processOrder(total);
    }
}