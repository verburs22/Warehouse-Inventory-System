public abstract class InventoryItem {
    //fields
    private String name;
    protected int quantity;
    private String sku;
    protected int reorderThreshold;

    // constructor
    public InventoryItem(String name, int quantity, String sku,  int reorderThreshold) {
        this.name = name;
        this.quantity = quantity;
        this.sku = sku;
        this.reorderThreshold = reorderThreshold;
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

    public int getReorderThreshold() {
        return reorderThreshold;
    }
}
