package com.model;

public class Vehicle {
    private int id;
    private String name;
    private String licensePlate;

    public Vehicle(int id, String name, String licensePlate) {
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}