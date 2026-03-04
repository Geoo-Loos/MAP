package model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.interfaces.InterfaceHas;

public class EntitysService<T extends InterfaceHas>   implements Comparator<T> {
    private List<T> list=new ArrayList<>();

     public void add(T obj) {
        list.add(obj);
    }

    public List<T> findAll() {
        return new ArrayList<>(list);
    }
  

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().toUpperCase()
                 .compareTo(o2.getName().toUpperCase());
    }
    
}
