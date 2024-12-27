package com.model;

public class Vehicle {
    private int id;
    private String vehicleName;
    private String licensePlate;
    private int userId;

    public Vehicle(int id, String vehicleName, String licensePlate, int userId) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.licensePlate = licensePlate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getUserId() {
        return userId;
    }
}
