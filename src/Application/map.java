package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.entity.Client;
import model.entity.Product;
import model.service.EntitysService;
import model.util.ClientFile;

public class map {
    public static void main(String[] args) {
         String path="src\\Compras.txt";
        EntitysService<Product> entitysService2=new EntitysService<>();
        List<Client> clients=new ArrayList<>();
        
        Product p1=new Product("Chocolate", 20.00);
        Product p2=new Product("Milk", 5.00);
        Product p3=new Product("Rice", 10.00);
        Product p4=new Product("Cake", 40.00);

       
        entitysService2.add(p1);
        entitysService2.add(p2);
        entitysService2.add(p3);
        entitysService2.add(p4);

        clients.add(new Client("Maria",p1));
        clients.add(new Client("Luisa",p2));
        clients.add(new Client("Ana",p3));
        clients.add(new Client("Luisa", p4));

         clients.removeIf(p->p.getProduct().getPrice()>=10.00);
         clients.forEach(p->p.getProduct().setPrice(p.getProduct().getPrice()+0.10));
       

        ClientFile clientFile=new ClientFile();
        clientFile.Save(clients, path);
        entitysService2.sort(new EntitysService<>(Product::getName));
        

        try (BufferedReader br= new BufferedReader(new FileReader(path))){
            Map<String, Integer> mapath = new TreeMap<>();
            String line = br.readLine();
            while (line !=null) {
                String[] fields = line.split(",");
                String name=fields[0];
                //int count=Integer.parseInt(fields[1]);

                if (mapath.containsKey(name)) {//verifica se uma chave especifica existe no conjunto
                    mapath.put(name,mapath.get(name)+1);
                    //Integer votes=mapath.get(name); //Busca o valor associado à chave.
                    //mapath.put(name, count+votes);
                } else {
                        mapath.put(name,1);
                    	//mapath.put(name, count);//Adiciona ou atualiza um par chave-valor.
                }line = br.readLine();
            }
             
            for (String key : mapath.keySet()) {
				System.out.println(key + ": " + mapath.get(key));
			}

            for(Client printer: clients){
                  System.out.println(printer);
            }
        } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
        }
    }
}
