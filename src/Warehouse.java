import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    //fields
    private List<InventoryItem> items;

    //constructor
    public Warehouse() {
        items = new ArrayList<>();
    }

    //methods
    public void addItem(InventoryItem item) {
        items.add(item);
    }

    public void generateReorderReport(){
        System.out.println("---- Reorder Report ----");
        for (InventoryItem item : items){
            System.out.println(item.getName() + " - Days until Reorder: " + item.daysUntilReorder() );
        }

    }

    public void generateShippingReport(){
        System.out.println("---- Shipping Report ---- ");
        for (InventoryItem item : items) {
            if (item instanceof Shippable shippableItem) {
                // shippableItem is already cast, ready to use, right here
                System.out.println(item.getName() + " - International? " +  shippableItem.canShipInternational() +
                        " - weight: " + shippableItem.calculateShippingWeight());
            }
        }
    }

}
