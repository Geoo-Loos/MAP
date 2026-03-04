package model.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.entity.Client;


public class ClientFile {
    public void Save(List<Client> clients, String path){
        try (BufferedWriter bw =new BufferedWriter(new FileWriter(path,true))){
            for(Client c : clients){
                
                  bw.write(c.getName()+", "
                + c.getProduct().getName()+","
            + c.getProduct().getPrice());
                  bw.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
