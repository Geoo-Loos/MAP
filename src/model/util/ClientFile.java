package model.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.entity.Client;

public class ClientFile {
    public void Save(Client client, String path){
        try (BufferedWriter bw =new BufferedWriter(new FileWriter(path,true))){
             bw.newLine();
             bw.write(client.toString());
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
