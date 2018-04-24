package com.danekblom.flightbase.controller;

import com.danekblom.flightbase.model.Airplane;

import java.util.ArrayList;

public class FleetManager {

    private ArrayList<Airplane> airplaneFleet = new ArrayList<>();

    public FleetManager() {
        // "default" constructor
    }

    /**
     * Method for adding an Airplane to the Fleet
     * @param airplane Object of type Airplane
     */
    public void addAirplaneToFleet(Airplane airplane) {

        airplaneFleet.add(airplane);
    }

    /**
     * Method to list all Airplanes in the Fleet and all booked Passengers, if any.
     */
    public void listFleet() {
        for (Airplane airplane : airplaneFleet) {
            System.out.println(airplane.getAirplaneName() + ", " +
                    airplane.getListBusinessPassengers().size() + " Business and "
                    + airplane.getListEconomyPassengers().size() + " Economy passengers booked.");
        }
    }

    /**
     * Method to simulate a flight
     * @param airplane Object of type Airplane
     */
    public void airplaneIsUnavailable(Airplane airplane) {
        Thread t1 = new Thread(airplane.getAirplaneName());

        try {
            t1.start();

            System.out.println(airplane.getAirplaneName() + ": Take off.");
            Thread.sleep(2000);

            System.out.println(airplane.getAirplaneName() + ": Refueling.");
            Thread.sleep(1000);

            System.out.println(airplane.getAirplaneName() + ": Flying back.");
            Thread.sleep(2000);

            System.out.println(airplane.getAirplaneName() + ": Refueling.");
            Thread.sleep(1000);

            System.out.println(airplane.getAirplaneName() + ": Ready for another run.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
