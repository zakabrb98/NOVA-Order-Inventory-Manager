public class Orderitem {
    private Product product ;
    private int quantity ;

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public Orderitem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double gettotal(){
        double total = 0 ;
        if (quantity > product.getStock()){
            throw new RuntimeException("u must to put the quantity <" + product.getStock());
        }
       return total = quantity * product.getPrice() ;
    }
}
