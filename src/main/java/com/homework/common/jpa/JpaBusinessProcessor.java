package com.homework.common.jpa;

import com.homework.common.Dog;
import com.homework.common.dao.DAO;
import com.homework.common.xls.XLSProcessor;

import java.io.File;
import java.util.List;

public class JpaBusinessProcessor implements DAO, XLSProcessor {

    public void save(Dog dog) {

    }

    public void remove(Dog dog) {

    }

    public void removeAll() {

    }

    public void update(Dog dog) {

    }

    public List<Dog> getAllDogs() {
        return null;
    }

    public void saveDataFromExcellTodatabase(File xlsFile) {

    }

    public void getDataFromDatabaseToExcell() {

    }
}
