package com.example.model;

import java.io.Serializable;
import java.sql.Date;

public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String description;
    private double price;
    private String destination;
    private Date startDate;
    private Date endDate;

    public Trip() {
        super();
    }

    public Trip(int id, String name, String description, double price) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Trip(String destination, String startDate, String endDate) {
        this.destination = destination;
        this.startDate = Date.valueOf(startDate);
        this.endDate = Date.valueOf(endDate);
    }

    public Trip(int id, String name, String description, double price, String destination, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}