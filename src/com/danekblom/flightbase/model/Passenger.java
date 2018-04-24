package com.danekblom.flightbase.model;

public class Passenger {

    private String firstName;
    private String lastName;
    private String ticketType;
    private String ticketID;
    private String food;
    private int foodCost;
    private String drink;
    private int drinkCost;
    private int seatNumber;
    private int totalTicketCost;

    public Passenger() {
        // Basic constructor
    }

    /**
     * Constructor with oall necessary parameters
     * @param firstName Passenger's first name, String
     * @param lastName Passenger's last name, String
     * @param ticketType Passenger's ticket type (Business or Economy), String
     * @param ticketID Passenger's unique ticket ID, String
     * @param food Passenger's chosen food item, String
     * @param foodCost Cost for Passenger's chosen food item, int
     * @param drink Passenger's chosen drink item, String
     * @param drinkCost Cost for Passenger's chosen drink item, int
     * @param seat Passenger's seat, String
     * @param airplane Passenger's flight. Of type Airplane
     */
    public Passenger(String firstName, String lastName, String ticketType, String ticketID, String food, int foodCost, String drink, int drinkCost, int seat, Airplane airplane) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticketType = ticketType;
        this.ticketID = ticketID;
        this.food = food;
        this.foodCost = foodCost;
        this.drink = drink;
        this.drinkCost = drinkCost;
        seatNumber = seat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(int foodCost) {
        this.foodCost = foodCost;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getDrinkCost() {
        return drinkCost;
    }

    public void setDrinkCost(int drinkCost) {
        this.drinkCost = drinkCost;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getTotalTicketCost() {
        int ticketPrice = 0;

        if (ticketType.equalsIgnoreCase("business")) {
            ticketPrice = 20000;
        }
        else {
            ticketPrice = 5000;
        }

        totalTicketCost = ticketPrice + getFoodCost() + getDrinkCost();
        return totalTicketCost;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Passenger ");
        sb.append(getFirstName());
        sb.append(" ");
        sb.append(getLastName());
        sb.append(" sits in the ");
        sb.append(getTicketType());
        sb.append(" section, seat ");
        sb.append(getSeatNumber());
        sb.append(". Consumables ordered are ");
        sb.append(getFood());
        sb.append(" and ");
        sb.append(getDrink());
//        sb.append(". Total flight cost is ");
//        sb.append(getTotalTicketCost());
        sb.append(".");

        return sb.toString();
    }
}
