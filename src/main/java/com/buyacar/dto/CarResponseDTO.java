package com.buyacar.dto;

import com.buyacar.model.Car;

public class CarResponseDTO {

    private Long id;
    private String model;
    private int year;
    private double price;
    private double mileage;
    private double engineCapacity;

    private String fuelType;
    private String transmission;
    private String color;
    private String bodyType;
    private String seatingCapacity;
    private String brandName;

    public CarResponseDTO() {}

    // Constructor to map from Car entity
    public CarResponseDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.year = car.getYear();
        this.price = car.getPrice();
        this.mileage = car.getMileage();
        this.engineCapacity = car.getEngineCapacity();

        this.fuelType = car.getFuelType() != null ? car.getFuelType().getValue() : null;
        this.transmission = car.getTransmission() != null ? car.getTransmission().getValue() : null;
        this.color = car.getColor() != null ? car.getColor().getValue() : null;
        this.bodyType = car.getBodyType() != null ? car.getBodyType().getValue() : null;
        this.seatingCapacity = car.getSeatingCapacity() != null ? car.getSeatingCapacity().getValue() : null;
        this.brandName = car.getBrand() != null ? car.getBrand().getName() : null;
    }

    // Getters and Setters
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

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getBodyType() { return bodyType; }
    public void setBodyType(String bodyType) { this.bodyType = bodyType; }

    public String getSeatingCapacity() { return seatingCapacity; }
    public void setSeatingCapacity(String seatingCapacity) { this.seatingCapacity = seatingCapacity; }

    public String getBrandName() { return brandName; }
    public void setBrandName(String brandName) { this.brandName = brandName; }
}
