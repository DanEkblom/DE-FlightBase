package com.danekblom.flightbase.devtest;

import com.danekblom.flightbase.model.Airplane;
import com.danekblom.flightbase.model.Passenger;
import com.danekblom.flightbase.model.Ticket;

//import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) {

        //Create a new airplane
        Airplane airplane01 = new Airplane("SAS SK1276", 5, 5);

        System.out.println(airplane01.toString());

        //Create a Passenger
        // Get Passenger info:
        String firstName;
        String lastName;
        String ticketType;
        String ticketID;
        String food;
        int foodCost;
        String drink;
        int drinkCost;
        int seat;

        firstName = "Dan";
        lastName = "Ekblom";
        ticketType = "Business";
        ticketID = "1";
        food = "Boeuf Bourginon";
        foodCost = 599;
        drink = "Bollinger '69";
        drinkCost = 259;
        seat = 0;

        Passenger passenger = new Passenger(firstName, lastName, ticketType, ticketID, food, foodCost, drink, drinkCost, seat, airplane01);

        airplane01.addPassenger(passenger, ticketType);

        //System.out.println(passenger.toString());
        //System.out.println(airplane01.getListBusinessPassengers());
        //System.out.println(airplane01.getTotalNumberOfOccupiedSeats());

        Ticket ticket = new Ticket(passenger);

        System.out.println(ticket.printTicket());

        //System.out.println("------------");

        String firstName2;
        String lastName2;
        String ticketType2;
        String ticketID2 = "1";
        String food2;
        int foodCost2;
        String drink2;
        int drinkCost2;

        firstName2 = "Henning";
        lastName2 = "Ekblom";
        ticketType2 = "Economy";
        ticketID2 = "2";
        food2 = "Pizza Napoli";
        foodCost2 = 79;
        drink2 = "Coca-Cola";
        drinkCost2 = 29;

        Passenger passenger2 = new Passenger(firstName2, lastName2, ticketType2, ticketID2, food2, foodCost2, drink2, drinkCost2, seat, airplane01);

        airplane01.addPassenger(passenger2, ticketType2);

        //System.out.println(passenger2.toString());
        //System.out.println(airplane01.getListBusinessPassengers());
        //System.out.println(airplane01.getListEconomyPassengers());
        //System.out.println(airplane01.getTotalNumberOfOccupiedSeats());

        Ticket ticket2 = new Ticket(passenger2);
        System.out.println(ticket2.printTicket());

        //System.out.println("------------");

        String firstName3;
        String lastName3;
        String ticketType3;
        String ticketID3 = "3";
        String food3;
        int foodCost3;
        String drink3;
        int drinkCost3;

        firstName3 = "Gustav";
        lastName3 = "Ekblom";
        ticketType3 = "Economy";
        food3 = "Club Sandwich";
        foodCost3 = 79;
        drink3 = "Juice";
        drinkCost3 = 25;

        Passenger passenger3 = new Passenger(firstName3, lastName3, ticketType3, ticketID3, food3, foodCost3, drink3, drinkCost3, seat, airplane01);

        airplane01.addPassenger(passenger3, ticketType3);

        Ticket ticket3 = new Ticket(passenger3);
        System.out.println(ticket3.printTicket());

        //System.out.println(passenger3.toString());
        System.out.println("---- Flight Info -----");
        System.out.println(airplane01.toString());
        System.out.println();
        System.out.println("--- Passenger List ---");
        //System.out.println(airplane01.getListBusinessPassengers());
        //System.out.println(airplane01.getListEconomyPassengers());
        //System.out.print("Number of occupied seats: " + airplane01.getTotalNumberOfOccupiedSeats());

        for (Passenger p : airplane01.getListBusinessPassengers()) {
            System.out.println(p);
        }

        for (Passenger p : airplane01.getListEconomyPassengers()) {
            System.out.println(p);
        }
    }
}
