package com.buyacar.model;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private int year;
    private double price;
    private double mileage;
    private double engineCapacity;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private LookUp fuelType;

    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private LookUp transmission;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private LookUp color;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private LookUp bodyType;

    @ManyToOne
    @JoinColumn(name = "seating_capacity_id")
    private LookUp seatingCapacity;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Car() {}

    public Car(String model, int year, double price, double mileage, double engineCapacity,
               LookUp fuelType, LookUp transmission, LookUp color,
               LookUp bodyType, LookUp seatingCapacity, Brand brand) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.color = color;
        this.bodyType = bodyType;
        this.seatingCapacity = seatingCapacity;
        this.brand = brand;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getMileage() { return mileage; }
    public void setMileage(double mileage) { this.mileage = mileage; }

    public double getEngineCapacity() { return engineCapacity; }
    public void setEngineCapacity(double engineCapacity) { this.engineCapacity = engineCapacity; }

    public LookUp getFuelType() { return fuelType; }
    public void setFuelType(LookUp fuelType) { this.fuelType = fuelType; }

    public LookUp getTransmission() { return transmission; }
    public void setTransmission(LookUp transmission) { this.transmission = transmission; }

    public LookUp getColor() { return color; }
    public void setColor(LookUp color) { this.color = color; }

    public LookUp getBodyType() { return bodyType; }
    public void setBodyType(LookUp bodyType) { this.bodyType = bodyType; }

    public LookUp getSeatingCapacity() { return seatingCapacity; }
    public void setSeatingCapacity(LookUp seatingCapacity) { this.seatingCapacity = seatingCapacity; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
}
