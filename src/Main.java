public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

       PerishableItem milk = new PerishableItem("Milk",25,"12345ABC", 10, 5, 3 );
       Electronics mouse = new Electronics("Mouse", 15, "54321CBA", 5, 1.5, false,10,2);
       BulkItem rice = new BulkItem("Rice Bags", 40, "A12B34C56", 10, 150, 10, 20);

       warehouse.addItem(milk);
       warehouse.addItem(mouse);
       warehouse.addItem(rice);

       System.out.println("---- Items Added: ---- ");
       System.out.println(milk.displayInfo());
       System.out.println(mouse.displayInfo());
       System.out.println(rice.displayInfo() + "\n");

       warehouse.generateReorderReport();
       System.out.println();
       warehouse.generateShippingReport();
    }
}
