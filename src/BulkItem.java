public class BulkItem extends InventoryItem implements Shippable{
    //fields
    private double weight;
    private int shippingQuantity;
    private static final double MAX_SHIPPABLE_WEIGHT = 100.0;
    private int daysSinceLastOrder;
    private static final int  REVIEW_CYCLE_DAYS = 30;

    // constructor
    public BulkItem(String name, int quantity, String sku, int reorderThreshold, double weight, int daysSinceLastOrder,
                    int shippingQuantity) {
        super(name, quantity, sku, reorderThreshold );
        this.weight = weight;
        this.daysSinceLastOrder = daysSinceLastOrder;
        this.shippingQuantity = shippingQuantity;
    }

    // methods
    @Override
    public int daysUntilReorder() {
            if(quantity <= reorderThreshold){
                return 0;
            }
        int daysLeftInCycle = REVIEW_CYCLE_DAYS - daysSinceLastOrder;
        return Math.max(daysLeftInCycle, 0);

        // ordered every 30 days unless stock is low
    }

    @Override
    public boolean canShipInternational() {
        double shippingWeight = calculateShippingWeight();
        if(shippingWeight > MAX_SHIPPABLE_WEIGHT){
            return false;
        }
        return true;
    }

    @Override
    public double calculateShippingWeight() {
        return shippingQuantity * weight;
    }

    //getters and setters
    public double getWeight() {
        return weight;
    }

    public int getShippingQuantity() {
        return shippingQuantity;
    }

    public int getDaysSinceLastOrder() {
        return daysSinceLastOrder;
    }
}
