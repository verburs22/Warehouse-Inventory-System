**Warehouse Inventory System - Java/IntelliJ IDEA**

Modeling items in a warehouse. Different item types (perishables, electronics, bulk goods) need different behavior like storage,
shipping, and ordering status. The behaviors of each item are repotated for ease of use. Methods consist of a combination of inheritance 
and multiple interface implementation.

**// Basic Design**
abstract class InventoryItem       // shared identity + shared implementation
    - name, quantity, sku (encapsulated fields)
    - getName(), getQuantity() (implemented once)
    - abstract daysUntilReorder()   // each subclass MUST define this differently

interface Shippable                 // a capability, not an identity
    - boolean canShipInternational()
    - double calculateShippingWeight()

- PerishableItem extends InventoryItem — has its own daysUntilReorder() based on expiration
- Electronics extends InventoryItem implements Shippable — inherits shared fields AND promises shipping behavior
- BulkItem extends InventoryItem — maybe doesn't implement Shippable at all (too heavy to ship individually)
