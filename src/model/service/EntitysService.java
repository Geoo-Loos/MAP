package model.service;

import java.util.ArrayList;
import java.util.List;

public class EntitysService<T> {
    private List<T> list=new ArrayList<>();

     public void add(T obj) {
        list.add(obj);
    }

    public List<T> findAll() {
        return new ArrayList<>(list);
    }
}
