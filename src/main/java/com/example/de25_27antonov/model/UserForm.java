package com.example.de25_27antonov.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserForm {
    private String name;
    private String busday;
    private String phone;
    private String email;
    private String inn;
    private String pasport;

    public UserForm() {

    }

    public String getName() {
        return name;
    }public String getPasport() {
        return pasport;
    }
    public String getInn() {
        return inn;
    }
    public String getEmail() {
        return email;
    }
    public String getbusday() {
        return busday;
    }
    public String getphone() {
        return phone;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
    public void setPasport(String pasport) {
        this.pasport = pasport;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBusday(String busday) {
        this.busday = busday;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void saveToDatabase(String dbUrl,String dbUser,String dbPass) throws SQLException {

        String sql = "INSERT INTO users (name, birthday, phone, email,inn,pasport) VALUES  (?,?,?,?,?,?)";

        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, this.name);
        stmt.setString(2, this.busday);
        stmt.setString(3, this.phone);
        stmt.setString(4, this.email);
        stmt.setString(5, this.inn);
        stmt.setString(6, this.pasport);
        stmt.executeUpdate();
    }

}


