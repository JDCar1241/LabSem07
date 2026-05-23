package observer;

public class EmailNotificationObserver implements OrderObserver {

    @Override
    public void update(String message) {
        System.out.println("Enviando correo al cliente...");
    }
}