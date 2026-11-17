import java.util.ArrayList;

public class InventoryService {
    private ArrayList<Product> products ;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public InventoryService(ArrayList<Product> products, ArrayList<Customer> customers, ArrayList<Order> orders) {
        this.products = products;
    }
    public void addProduct(Product p){
     if (products.contains(p)){
         throw new RuntimeException("this product  exists : "+p.getName()+
                 "| his id is : "+p.getId());
        }
     if (!products.contains(p)){
         products.add(p);
     }
    }
    public Product findProductById( int id){
     for (Product p : products ){
         if (p.getId()==id){
             return p;
         }
     }
     throw new RuntimeException("this product doesn't exists");
    }
    public void listProducts(){
       for (int i =0 ; i< products.size() ; i++){
           Product p = products.get(i);
       }
    }
    public void removeProduct(Product p) {
        if (!products.contains(p)) {
            throw new RuntimeException("the product doesn't exists ");
        }
        if (products.contains(p)) {
            products.remove(p);
        }
    }

}
