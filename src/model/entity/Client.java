package model.entity;

public class Client {
    private String name;
    private Product product;
   
    
   

    public Client(String name, Product product) {
        this.name = name;
        this.product =product;
      
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void addProduct(Product p){
        this.addProduct(p);
    }

     public void removeProduct(Product p){
        this.removeProduct(p);
    }


    public Product getProduct() {
         return product;
     }

     @Override
     public String toString() {
        return name +", "+ product.toString();
     }

     
  
}
