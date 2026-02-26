package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import model.entity.Client;
import model.service.EntitysService;

public class map {
    public static void main(String[] args) {
        
        
        EntitysService<Client> entitysService=new EntitysService<>();

        entitysService.add(new Client("Maria","Chocolate",100.0));
        
        
        
        
        String path="src\\Votos.txt";

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
        } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
        }
    }
}
