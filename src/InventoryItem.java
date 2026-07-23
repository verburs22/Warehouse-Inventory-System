public abstract class InventoryItem {
    //fields
    private String name;
    private int quantity;
    private String sku;

    // constructor
    public InventoryItem(String name, int quantity, String sku) {
        this.name = name;
        this.quantity = quantity;
        this.sku = sku;
    }

    // methods
    public abstract int daysUntilReorder();

    public String displayInfo() {
        return name + " (SKU: " + sku + ") - Qty: " + quantity;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSku() {
        return sku;
    }
}
