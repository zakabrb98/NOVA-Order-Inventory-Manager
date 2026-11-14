public class Product {
    private final int id ;
    private final String name ;
    private final double price ;
    private int stock ;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        if (price>0 || stock>=0){
            this.price = price ;
            this.stock = stock ;
        }
        else {
            throw new Customexceptions(price , stock);
        }
    }
    public int addstock(int quantity){
        if(quantity<=0){
            throw new RuntimeException("error enter again ur quantity");
        }
        this.stock += quantity ;
        return  this.stock ;
    }
    public int removestock(int quantity){
        if (quantity<=0){
            throw new RuntimeException("error enter again ur quantity");
        }
        this.stock -= quantity ;
        return this.stock ;
    }
    public String toString(){
        return        "Product: " + name + " | id: " + id + " | stock increased by  New stock: " + stock;
    }
}
