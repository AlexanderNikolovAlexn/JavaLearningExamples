package com.homework.common.jdbc;

import com.homework.common.Dog;
import com.homework.common.dao.DAO;
import com.homework.common.xls.XLSProcessor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBusinessProcessor implements DAO, XLSProcessor {

    private Connection connection;

    private final String[] columns = {"Name", "Age", "Gender", "Weight", "Height"};

    public JdbcBusinessProcessor() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alex", "alex", "alex");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Dog dog) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into dog(name, age, male, weight, height) values(?, ?, ?, ?, ?)");
            ps.setString(1, dog.getName());
            ps.setInt(2, dog.getAge());
            ps.setInt(3, (dog.isMale()) ? 1 : 0);
            ps.setFloat(4, dog.getWeight());
            ps.setInt(5, dog.getHeight());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void remove(Dog dog) {

    }

    public void removeAll() {

    }

    public void update(Dog dog) {

    }

    public List<Dog> getAllDogs() {
        List<Dog> list = new ArrayList<Dog>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from dog");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Dog dog = new Dog(rs.getString("name"), rs.getInt("age"), rs.getFloat("weight"), (rs.getInt("male") == 1), rs.getInt("height"));
                list.add(dog);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return list;
        }
    }

    public void saveDataFromExcellTodatabase(File xlsFile) {

    }

    public void getDataFromDatabaseToExcell()
    {
        List<Dog> list = getAllDogs();
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("All Dogs");
        int rownum = 0;
        XSSFRow row = sheet.createRow(rownum++);
        for (int i = 0; i < columns.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(columns[i]);
        }
        for(Dog dog: list) {
            row = sheet.createRow(rownum++);
            int colnum = 0;
            XSSFCell cell = row.createCell(colnum++);
            cell.setCellValue(dog.getName());
            cell = row.createCell(colnum++);
            cell.setCellValue(dog.getAge());
            cell = row.createCell(colnum++);
            cell.setCellValue((dog.isMale()) ? "Male" : "Female");
            cell = row.createCell(colnum++);
            cell.setCellValue(dog.getWeight());
            cell = row.createCell(colnum++);
            cell.setCellValue(dog.getHeight());
        }

        OutputStream out = null;
        try {
            out = new FileOutputStream(new File("data//dogs.xls"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
