package com.homework.common.dao;

import com.homework.common.Dog;

import java.util.List;

public interface DAO {

    public void save(Dog dog);
    public void remove(Dog dog);
    public void removeAll();
    public void update(Dog dog);
    public List<Dog> getAllDogs();

}
