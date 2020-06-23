package com.raczkowski.apps.model.repository;

import com.raczkowski.apps.model.User;
import com.raczkowski.apps.model.UserRegistrationData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersJDBCDao implements UsersDao {

    private final String url = "jdbc:postgresql://localhost:5432/articleservice";
    private final String user = "postgres";
    private final String password = "Tajfun";

    @Override
    public void addUser(UserRegistrationData user) {
        Connection connection = connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(id, name, lastname, email, password) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, loadUsers().size());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> loadUsers() {
        Connection connection = connect();
        Statement statement;
        List<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                String eMail = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(id, name, lastName, eMail, password);
                users.add(user);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Articles DataBase.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
