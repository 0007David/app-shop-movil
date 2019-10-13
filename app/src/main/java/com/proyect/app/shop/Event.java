package com.proyect.app.shop;

public class Event {

    private Integer id;
    private String name;
    private String date;
    private String address;
    private String latitude;
    private String length;
    private Double total_amount;
    private Double transport_cost;
    private Float additional_amount;
    private String state;
    private Integer cart_id;
    private Integer score_id;


    public Event(String name, String address, String date, String state, Double totalAmount, Double transportCost){
        this.name = name;
        this.address = address;
        this.date = date;
        this.state = state;
        this.total_amount = totalAmount;
        this.transport_cost = transportCost;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLength() {
        return length;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public Double getTransport_cost() {
        return transport_cost;
    }

    public Float getAdditional_amount() {
        return additional_amount;
    }

    public String getState() {
        return state;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public Integer getScore_id() {
        return score_id;
    }


    @Override
    public String toString() {
        return "Event{" +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", total_amount=" + total_amount +
                ", transport_cost=" + transport_cost +
                ", state='" + state + '\'' +
                '}';
    }
}
