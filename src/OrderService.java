import java.util.ArrayList;

public class OrderService {
    private ArrayList<Order> orders ;
    private ArrayList<Product> products;
    private InventoryService inventoryService ;

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public OrderService(ArrayList<Order> orders, ArrayList<Product> products, InventoryService inventoryService) {
        this.orders = orders;
        this.products = products;
        this.inventoryService = inventoryService;
    }

   public Order createOrder(int id){
        for (Order order : orders){
            if (order.getId()!= id){
                return order ;
            }
        }
        throw new RuntimeException("u cannot create order ") ;
   }
   public void addItemToOrder(){

   }
}
