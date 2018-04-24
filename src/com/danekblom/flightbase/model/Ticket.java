package com.danekblom.flightbase.model;

public class Ticket {

    public static int businessTicketCost = 20000;
    public static int economyTicketCost = 5000;

    private String pFirstName;
    private String pLastName;
    private String pTicketType;
    private String pTicketID;
    private String pFood;
    private int pFoodCost;
    private String pDrink;
    private int pDrinkCost;
    private int pConsumablesCost;
    private int pSeatNumber;

    public Ticket() {
        // basic constructor
    }

    /**
     * Constructor with only Passenger object
     * @param passenger Object of type Passenger
     */
    public Ticket(Passenger passenger) {
        this.pFirstName = passenger.getFirstName();
        this.pLastName = passenger.getLastName();
        this.pTicketType = passenger.getTicketType();
        this.pTicketID = passenger.getTicketID();
        this.pFood = passenger.getFood();
        this.pFoodCost = passenger.getFoodCost();
        this.pDrink = passenger.getDrink();
        this.pDrinkCost = passenger.getDrinkCost();
        this.pSeatNumber = passenger.getSeatNumber();
        pConsumablesCost = pFoodCost + pDrinkCost;
    }

    public static int getBusinessTicketCost() {
        return businessTicketCost;
    }

    public static void setBusinessTicketCost(int businessTicketCost) {
        Ticket.businessTicketCost = businessTicketCost;
    }

    public static int getEconomyTicketCost() {
        return economyTicketCost;
    }

    public static void setEconomyTicketCost(int economyTicketCost) {
        Ticket.economyTicketCost = economyTicketCost;
    }

    public String getpFirstName() {
        return pFirstName;
    }

    public void setpFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public String getpLastName() {
        return pLastName;
    }

    public void setpLastName(String pLastName) {
        this.pLastName = pLastName;
    }

    public String getpTicketType() {
        return pTicketType;
    }

    public void setpTicketType(String pTicketType) {
        this.pTicketType = pTicketType;
    }

    public String getpTicketID() {
        return pTicketID;
    }

    public void setpTicketID(String pTicketID) {
        this.pTicketID = pTicketID;
    }

    public String getpFood() {
        return pFood;
    }

    public void setpFood(String pFood) {
        this.pFood = pFood;
    }

    public int getpFoodCost() {
        return pFoodCost;
    }

    public void setpFoodCost(int pFoodCost) {
        this.pFoodCost = pFoodCost;
    }

    public String getpDrink() {
        return pDrink;
    }

    public void setpDrink(String pDrink) {
        this.pDrink = pDrink;
    }

    public int getpDrinkCost() {
        return pDrinkCost;
    }

    public void setpDrinkCost(int pDrinkCost) {
        this.pDrinkCost = pDrinkCost;
    }

    public int getpConsumablesCost() {
        return pConsumablesCost;
    }

    public void setpConsumablesCost(int pConsumablesCost) {
        this.pConsumablesCost = pConsumablesCost;
    }

    public int getpSeatNumber() {
        return pSeatNumber;
    }

    public void setpSeatNumber(int pSeatNumber) {
        this.pSeatNumber = pSeatNumber;
    }

    private int getTotalCost() {
        if (pTicketType.equals("Business")) {
            return pConsumablesCost + businessTicketCost;
        }
        else {
            return pConsumablesCost + economyTicketCost;
        }
    }

    public String printTicket() {
        StringBuilder sb = new StringBuilder("|________________________\n");
        sb.append("| Your Booking Info   \n");
        sb.append("| - - - - - - - - - - - -\n");
        sb.append("| Ticket ID: ");
        sb.append(getpTicketID());
        sb.append("\n| Name: ");
        sb.append(getpFirstName());
        sb.append(" ");
        sb.append(getpLastName());
        sb.append("\n| - - - - - - - - - - - -\n");
        sb.append("| Class: ");
        sb.append(getpTicketType());
        sb.append("\n| Seat #: ");
        sb.append(getpSeatNumber());
        sb.append("\n| - - - - - - - - - - - -");
        sb.append("\n| Food & Drink: \n");
        sb.append("| ");
        sb.append(getpFood());
        sb.append(", ");
        sb.append(getpFoodCost());
        sb.append(":-\n");
        sb.append("| ");
        sb.append(getpDrink());
        sb.append(", ");
        sb.append(getpDrinkCost());
        sb.append(":-");
        sb.append("\n| Total: ");
        sb.append(getpConsumablesCost());
        sb.append(":-");
        sb.append("\n| - - - - - - - - - - - -");
        sb.append("\n| Total Ticket Cost: \n");
        sb.append("| ");
        sb.append(getTotalCost());
        sb.append(":-");
        sb.append("\n|________________________\n");
        //sb.append("\n* * * * * * * * * * * *\n");

        return sb.toString();
    }
}
