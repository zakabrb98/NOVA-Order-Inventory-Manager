import java.util.List;

public class Order {
    private int id ;
    private Customer customer ;
    private List<Orderitem> items ;
    private Status status ;

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Orderitem> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }

    public Order(int id, Customer customer, List<Orderitem> items, Status status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public void additem(Product product , int quantity){
        if(product == null){
            throw new RuntimeException("enter ur product for add it");
        }
        if (quantity<0){
            throw new RuntimeException("the quantity can't being negative");
        }
        Orderitem item = new Orderitem(product , quantity) ;
        items.add(item) ;
    }
    public double gettotal(){
        double total = 0 ;
        for (Orderitem item : items){
            total = total + item.gettotal();
        }
        return total ;
    }
    public void confirm(){
        if (status !=Status.PENDING){
            throw new RuntimeException("u must to pending ur order");
        }
        if (items.isEmpty()){
            throw new RuntimeException("we cannot confirm empty order");
        }
        for (Orderitem item : items){
            Product product = item.getProduct() ;
            if (item.getQuantity()> product.getStock()){
                throw new RuntimeException("the order "+product.getName()+"is bigger than the quantity of the stock : "
                                  +product.getStock());
            }
        }
        for (Orderitem item : items){
            item.getProduct().removestock(item.getQuantity());
        }
        status = Status.CONFIRMED ;
    }
    public void cancel(){
        if (status != Status.CANCELLED){
            throw new RuntimeException("ur order is already cancelled");
        }
        if (items.isEmpty()){
            throw new RuntimeException("we cannot cancel empty order");
        }
        if (status == Status.CONFIRMED){
            for (Orderitem item : items){
                item.getProduct().addstock(item.getQuantity());
            }
        }
    }
}
