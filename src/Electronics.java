public class Electronics extends InventoryItem implements Shippable{
    //fields
    private double weight;
    private boolean containsLithiumBattery;
    private int shippingQuantity;
    private int averageDailySales;

    public Electronics(String name, int quantity, String sku,  int reorderThreshold,  double weight,
                       boolean containsLithiumBattery, int shippingQuantity, int averageDailySales) {
        super(name, quantity, sku, reorderThreshold);
        this.weight = weight;
        this.containsLithiumBattery = containsLithiumBattery;
        this.shippingQuantity = shippingQuantity;
        this.averageDailySales = averageDailySales;
    }

    //methods
    @Override
    public int daysUntilReorder() {
        int safeSalesRate = averageDailySales;
        if(averageDailySales == 0){
            safeSalesRate = 1;
            // no sales data yet — default to 1/day until real data is collected
        }
        return (quantity <= reorderThreshold ) ? 0 : (quantity - reorderThreshold)/ safeSalesRate;
        // statistics to simulate selling?
    }

    @Override
    public boolean canShipInternational() {
        return !containsLithiumBattery;
        // cannot ship if electronic contains large lithium batteries
    }

    @Override
    public double calculateShippingWeight() {
        return shippingQuantity * weight;
    }

    //getters and setters
    public double getWeight() {
        return weight;
    }

    public boolean hasContainsLithiumBattery() {
        return containsLithiumBattery;
    }

    public int getShippingQuantity() {
        return shippingQuantity;
    }

    public boolean isContainsLithiumBattery() {
        return containsLithiumBattery;
    }

    public int getAverageDailySales() {
        return averageDailySales;
    }
}
