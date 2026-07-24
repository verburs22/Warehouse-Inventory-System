public class PerishableItem extends InventoryItem {
    //fields
    private int daysToExpiration;
    private int shippingTime;

    public PerishableItem(String name, int quantity, String sku,int reorderThreshold, int daysToExpiration,  int shippingTime) {
        super(name, quantity, sku, reorderThreshold);
        this.daysToExpiration = daysToExpiration;
        this.shippingTime = shippingTime;
    }

    //methods
    @Override
    public int daysUntilReorder() {
        int reorder = daysToExpiration - shippingTime;
        if (quantity <= reorderThreshold){
            return 0; // if stock is below threshold then 0 - order more
        }
        return (reorder > 0) ? reorder : 0;

        // if reorder is negative, 0 is returned. can add 'overdue' method to alert for
        // items are past the date they need to be reordered
    }

    //getter and setters
    public int getDaysToExpiration() {
        return daysToExpiration;
    }

    public int getShippingTime() {
        return shippingTime;
    }
}
