public class Customexceptions extends RuntimeException {
    private final double price;

    private final int stock;

    public Customexceptions(double price , int stock) {
        super("Invalid price: " + price + ". Price must be greater than 0 | the stock must being 0 or greater " + stock);
        this.price = price;
        this.stock = stock ;
    }

    public double getPrice() {
        return price;
    }
    public int getStock(){
        return stock ;
    }
}
