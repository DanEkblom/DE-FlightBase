package com.danekblom.flightbase.model;

import com.danekblom.flightbase.controller.FleetManager;

import java.util.ArrayList;

public class Airplane {

    private int numberOfBusinessSeats;
    private int numberOfEconomySeats;

    private static int numberOfOccupiedBusinessSeats;
    private static int numberOfOccupiedEconomySeats;

    private String airplaneName;

    private ArrayList<Passenger> listBusinessPassengers = new ArrayList<>();
    private ArrayList<Passenger> listEconomyPassengers = new ArrayList<>();
    private ArrayList<Passenger> listAllPassengers = new ArrayList<>(numberOfBusinessSeats + numberOfEconomySeats);

    public Airplane() {
        // Basic constructor
    }

    /**
     * Constructor with only airplane name
     * @param airplaneName Airplane unique name, String
     */
    public Airplane(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    /**
     * Constructor with airplane name and numbers for business and economy passenger lists
     * @param airplaneName Airplane unique name, String
     * @param numberOfBusinessSeats Number of business passengers, int
     * @param numberOfEconomySeats Number of economy passengers, int
     */
    public Airplane(String airplaneName, int numberOfBusinessSeats, int numberOfEconomySeats) {
        this.airplaneName = airplaneName;
        this.numberOfBusinessSeats = numberOfBusinessSeats;
        this.numberOfEconomySeats = numberOfEconomySeats;
    }

    public String getAirplaneName() {

        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {

        this.airplaneName = airplaneName;
    }


    public int getNumberOfBusinessSeats() {
        return numberOfBusinessSeats;
    }

    public int getNumberOfEconomySeats() {
        return numberOfEconomySeats;
    }


    public int getNumberOfOccupiedBusinessSeats() {
        return numberOfOccupiedBusinessSeats + 1;
    }

    public void setNumberOfOccupiedBusinessSeats(int numberOfOccupiedBusinessSeats) {
        this.numberOfOccupiedBusinessSeats = numberOfOccupiedBusinessSeats + 1;
    }


    public int getNumberOfOccupiedEconomySeats() {
        return numberOfOccupiedEconomySeats + 6;
    }

    public void setNumberOfOccupiedEconomySeats(int numberOfOccupiedEconomySeats) {
        this.numberOfOccupiedEconomySeats = numberOfOccupiedEconomySeats + 1;
    }



    public ArrayList<Passenger> getListBusinessPassengers() {
        return listBusinessPassengers;
    }

    public void setListBusinessPassengers(ArrayList<Passenger> listBusinessPassengers) {
        this.listBusinessPassengers = listBusinessPassengers;
    }


    public ArrayList<Passenger> getListEconomyPassengers() {
        return listEconomyPassengers;
    }

    public void setListEconomyPassengers(ArrayList<Passenger> listEconomyPassengers) {
        this.listEconomyPassengers = listEconomyPassengers;
    }


    public ArrayList<Passenger> getListAllPassengers() {
        for (Passenger bp : listBusinessPassengers) {
            listAllPassengers.add(bp);
        }

        for (Passenger ep: listEconomyPassengers) {
            listAllPassengers.add(ep);
        }
        return listAllPassengers;
    }

    public void setListAllPassengers(ArrayList<Passenger> listAllPassengers) {
        this.listAllPassengers = listAllPassengers;
    }


    /*
    public int getSeat(Passenger passenger) {
        return getListAllPassengers().indexOf(passenger) + 2;
    }
    */

    public int getTotalNumberOfOccupiedSeats() {
        return listEconomyPassengers.size() + listBusinessPassengers.size();
    }

    public void addPassenger(Passenger passenger, String list) {
        if (list.equals("Business") && (listBusinessPassengers.size() < 5)) {
            listBusinessPassengers.add(passenger);
            listAllPassengers.add(passenger);
            ++numberOfOccupiedBusinessSeats;

        }
        if (list.equals("Economy") && (listEconomyPassengers.size() < 5)){
            listEconomyPassengers.add(passenger);
            listAllPassengers.add(passenger);
            ++numberOfOccupiedEconomySeats;
        }
    }

    public boolean isAirplaneFull(Airplane airplane) {
        if (airplane.getListBusinessPassengers().size() == 5 && airplane.getListEconomyPassengers().size() == 5) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Flight ");
        sb.append(getAirplaneName());
        sb.append(" seats ");
        sb.append(getNumberOfBusinessSeats());
        sb.append(" Business passengers and ");
        sb.append(getNumberOfEconomySeats());
        sb.append(" Economy passengers.\nCurrently, ");

        if (getTotalNumberOfOccupiedSeats() == 0) {
            sb.append("no");
        }
        else {
            sb.append(getTotalNumberOfOccupiedSeats());
        }

        sb.append(" passenger(s) is/are booked on this flight; ");

        if (getListBusinessPassengers().size() == 0) {
            sb.append("no");
        }
        else {
            sb.append(getListBusinessPassengers().size());
        }

        sb.append(" Business and ");

        if (getListEconomyPassengers().size() == 0) {
            sb.append("no");
        }
        else {
            sb.append(getListEconomyPassengers().size());
        }

        sb.append(" Economy.\n");

        return sb.toString();

    }
}
