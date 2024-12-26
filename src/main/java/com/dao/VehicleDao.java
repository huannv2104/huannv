package com.dao;

import com.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static final String URL = "jdbc:mysql://localhost:3306/trafficmanagement";
    private static final String USER = "root";
    private static final String PASSWORD = "NVH@21042104ok";

    private Connection connection;

    public VehicleDao() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(resultSet.getInt("id"));
            vehicle.setName(resultSet.getString("name"));
            vehicle.setLicensePlate(resultSet.getString("license_plate"));
            vehicle.setUserId(resultSet.getInt("user_id"));
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO vehicles (name, license_plate, user_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vehicle.getName());
        preparedStatement.setString(2, vehicle.getLicensePlate());
        preparedStatement.setInt(3, vehicle.getUserId());
        preparedStatement.executeUpdate();
    }

    public void updateVehicle(Vehicle vehicle) throws SQLException {
        String sql = "UPDATE vehicles SET name = ?, license_plate = ?, user_id = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vehicle.getName());
        preparedStatement.setString(2, vehicle.getLicensePlate());
        preparedStatement.setInt(3, vehicle.getUserId());
        preparedStatement.setInt(4, vehicle.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteVehicle(int id) throws SQLException {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}