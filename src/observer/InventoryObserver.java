package observer;

public class InventoryObserver implements OrderObserver {

    @Override
    public void update(String message) {
        System.out.println("Actualizando inventario...");
    }
}