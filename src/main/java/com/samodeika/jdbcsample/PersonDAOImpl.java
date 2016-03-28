package com.samodeika.jdbcsample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    public List<Person> getPersons() {
        try(Connection c = getConnection()) {
            List<Person> list = new ArrayList<>();
            PreparedStatement ps = c.prepareStatement("select * from tmp_table");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person p = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                list.add(p);
            }
            return list;
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Person getPerson(int id) {
        return null;
    }

    public void update(Person person) {

    }

    public void remove(Person person) {

    }

    public boolean insert(Person person) {
        return false;
    }

    public void getPersonsAsXLS() {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/alex", "alex", "alex");
    }
}
