package com.buyacar.dto;

import com.buyacar.model.Car;

public class CarRequestDTO {

    private String name;
    private int year;
    private double price;
    private double mileage;
    private double engineCapacity;

    private Long fuelTypeId;
    private Long transmissionId;
    private Long colorId;
    private Long bodyTypeId;
    private Long seatingCapacityId;
    private Long brandNameId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Long getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(Long transmissionId) {
        this.transmissionId = transmissionId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getBodyTypeId() {
        return bodyTypeId;
    }

    public void setBodyTypeId(Long bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public Long getSeatingCapacityId() {
        return seatingCapacityId;
    }

    public void setSeatingCapacityId(Long seatingCapacityId) {
        this.seatingCapacityId = seatingCapacityId;
    }

    public Long getBrandNameId() {
        return brandNameId;
    }

    public void setBrandNameId(Long brandNameId) {
        this.brandNameId = brandNameId;
    }
}