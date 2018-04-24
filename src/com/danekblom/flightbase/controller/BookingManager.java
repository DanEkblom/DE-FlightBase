package com.danekblom.flightbase.controller;

import com.danekblom.flightbase.model.Airplane;
import com.danekblom.flightbase.model.Passenger;
import com.danekblom.flightbase.model.Ticket;
import com.danekblom.flightbase.ui.SystemUI;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {

    public void addPassenger(Scanner sc, Airplane airplane) {

        String firstName;
        String lastName;
        String ticket;
        String ticketID;
        String foodOption;
        String food;
        int foodCost;
        String drinkOption;
        String drink;
        int drinkCost;
        int seat;
        String switchTicket;

        if (airplane.getTotalNumberOfOccupiedSeats() < 10) {

            // Get first name
            System.out.println("\nWhat's your first name?");
            firstName = sc.next();

            // Get last name
            System.out.println("\nWhat's your last name?");
            lastName = sc.next();

            // Get preferred ticket
            System.out.println("\nWhich kind of ticket would you like?\n" +
                    "[1] Business (20.000:-)\n" +
                    "[2] Economy (5.000:-)");
            ticket = sc.next();

            String ticketType = "";

            if (ticket.equals("1") && airplane.getListBusinessPassengers().size() < 5) {
                ticketType = "Business";
            } else if (ticket.equals("1") && airplane.getListBusinessPassengers().size() == 5) {
                System.out.println("We\'re sorry. No Business seats available. " +
                        "Would you like an Economy ticket?\n" +
                        "[1] Yes\n" +
                        "[2] No, cancel my booking\n");
                switchTicket = sc.next();

                switch (switchTicket) {
                    case "1": {
                        ticketType = "Economy";
                        //airplane.addPassenger(passenger, ticketType);
                        //System.out.println("Thank you for travelling with us. You can view your ticket info from the main menu.");
                        break;
                    }
                    case "2": {
                        System.out.println("We\'re sorry we couldn\'t help you today, and we hope you\'ll come back later.");
                        new SystemUI();
                        break;
                    }
                    default:
                        System.out.println("No such option. Please choose another.");
                }
            }

            if (ticket.equals("2") && airplane.getListEconomyPassengers().size() < 5) {
                ticketType = "Economy";
            } else if (ticket.equals("Economy") && airplane.getListEconomyPassengers().size() == 5) {
                System.out.println("We\'re sorry. No Economy seats available. " +
                        "Would you like a Business ticket?\n" +
                        "[1] Yes\n" +
                        "[2] No, cancel my booking\n");
                switchTicket = sc.next();

                switch (switchTicket) {
                    case "1": {
                        ticketType = "Business";
                        //airplane.addPassenger(passenger, ticketType);
                        //System.out.println("Thank you for travelling with us. You can view your ticket info from the main menu.");
                        break;
                    }
                    case "2": {
                        System.out.println("We\'re sorry we couldn\'t help you today, and we hope you\'ll come back later.");
                        new SystemUI();
                    }
                    default:
                        System.out.println("No such option. Please choose another.");
                }
            }

            // Set ticket ID
            String ticketClass;
            if (ticketType.equalsIgnoreCase("Business")) {
                ticketClass = "B";
                ticketID = ticketClass + (airplane.getNumberOfOccupiedBusinessSeats());
            }
            else {
                ticketClass = "E";
                ticketID = ticketClass + (airplane.getNumberOfOccupiedEconomySeats());
            }


            // Get preferred food.
            // Food items vary based on ticket type.
            // TODO: Create a Consumables class/handler?
            if (ticketType.equals("Business")) {
                System.out.println("\nWhat would you like to eat?\n" +
                        "[1] Boeuf Bourguignon served with potato gratin and crisp vegetables, 199:-\n" +
                        "[2] Coq au Vin served with seasonal vegetables on a bed of rice, 179:-\n" +
                        "[3] Nothing");
            } else {
                System.out.println("\nWhat would you like to eat?\n" +
                        "[1] Pizza Vesuvio (tomato sauce, cheese and ham), 79:-\n" +
                        "[2] Hamburger plate with fries, 89:-\n" +
                        "[3] Nothing");
            }
            foodOption = sc.next();

            // food field population based on ticket type
            // initialize food fields
            food = "";
            foodCost = 0;

            if (ticketType.equals("Business")) {

                switch (foodOption) {
                    case "1": {
                        food = "Boeuf Bourguignon";
                        foodCost = 199;
                        break;
                    }
                    case "2": {
                        food = "Coq au Vin";
                        foodCost = 179;
                        break;
                    }
                    case "3": {
                        food = "nothing";
                        foodCost = 0;
                        break;
                    }
                    default:
                        System.out.println("No such option. Please choose another.");
                }

            } else {

                switch (foodOption) {
                    case "1": {
                        food = "Pizza Vesuvio";
                        foodCost = 79;
                        break;
                    }
                    case "2": {
                        food = "Hamburger plate";
                        foodCost = 89;
                        break;
                    }
                    case "3": {
                        food = "nothing";
                        foodCost = 0;
                        break;
                    }
                    default:
                        System.out.println("No such option. Please choose another.");
                }

            }


            // Get preferred drink.
            // Drink items vary based on ticket type.
            if (ticketType.equals("Business")) {
                System.out.println("\nWhat would you like to drink?\n" +
                        "[1] Chateau Villeneuve \'98 wine (red), 79:-\n" +
                        "[2] Sierra Nevada Porter beer, 49:-\n" +
                        "[3] Water, sparkling, with lemon or lime, 29:-");
            } else {
                System.out.println("\nWhat would you like to drink?\n" +
                        "[1] Coca-Cola, 25:-\n" +
                        "[2] Pripps Light beer, 35:-\n" +
                        "[3] Water from the tap, 15:- ");
            }
            drinkOption = sc.next();


            // drink field population based on ticket type
            // initialize drink fields
            drink = "";
            drinkCost = 0;

            if (ticketType.equals("Business")) {

                switch (drinkOption) {
                    case "1": {
                        drink = "Chateau Villeneuve";
                        drinkCost = 79;
                        break;
                    }
                    case "2": {
                        drink = "Sierra Nevada Porter beer";
                        drinkCost = 49;
                        break;
                    }
                    case "3": {
                        food = "Sparkling water";
                        foodCost = 29;
                        break;
                    }
                    default:
                        System.out.println("No such option. Please choose another.");
                }

            } else {

                switch (foodOption) {
                    case "1": {
                        drink = "Coca-Cola";
                        drinkCost = 25;
                        break;
                    }
                    case "2": {
                        drink = "Pripps Light beer";
                        drinkCost = 35;
                        break;
                    }
                    case "3": {
                        drink = "water";
                        drinkCost = 15;
                        break;
                    }
                    default:
                        System.out.println("No such option. Please choose another.");
                }

            }

            // Create Passenger object from fields above

            if (ticketType.equals("Business")) {
                seat = airplane.getNumberOfOccupiedBusinessSeats();
            }
            else {
                seat = airplane.getNumberOfOccupiedEconomySeats();
            }

            Passenger passenger = new Passenger(firstName, lastName, ticketType, ticketID, food, foodCost, drink, drinkCost, seat, airplane);
            airplane.addPassenger(passenger, ticketType);

            // Print ticket
            System.out.println("Thank you! All done! Here\'s a copy of your ticket.\nBe sure to note the ticket ID for future reference!\n");
            Ticket printedTicket = new Ticket(passenger);
            System.out.println(printedTicket.printTicket());

            if (airplane.isAirplaneFull(airplane)) {

                System.out.println("Plane is full and will take-off shortly!");

                // Simulate flight
                FleetManager fm = new FleetManager();
                fm.airplaneIsUnavailable(airplane);

                // Empty airplane arrays
                List<Passenger> bList = airplane.getListBusinessPassengers();
                List<Passenger> eList = airplane.getListEconomyPassengers();

                bList.clear();
                eList.clear();

                //System.out.println("Lists emptied!");

            }
            else {
                // Do nothing...
            }

        }
        else {
            System.out.println("We\'re sorry. No seats left on this flight...\n\n");
        }
    }

    public void findPassenger(Scanner sc, Airplane airplane) {

        System.out.println("Fill in your ticket ID to see your ticket:");
        String ticketID = sc.next();
        String ticketClass = ticketID.substring(0, 1);

        if (ticketClass.equalsIgnoreCase("B")) {
            for (int i = 0; i < airplane.getListBusinessPassengers().size(); i++) {
                Passenger foundPassenger = airplane.getListBusinessPassengers().get(i);
                Ticket ticket = new Ticket(foundPassenger);
                System.out.println(ticket.printTicket());
            }
        }
        else if (ticketClass.equalsIgnoreCase("E")) {
            for (int i = 0; i < airplane.getListEconomyPassengers().size(); i++) {
                Passenger foundPassenger = airplane.getListEconomyPassengers().get(i);
                Ticket ticket = new Ticket(foundPassenger);
                System.out.println(ticket.printTicket());
            }
        }
        else {
            System.out.println("Sorry, the ticket ID can\'t be found. Please try again.");
        }
    }

    public void cancelTicket(Scanner sc, Airplane airplane) {
        System.out.println("Fill in your ticket ID to cancel your ticket:");
        String ticketID = sc.next();

        String ticketClass = ticketID.substring(0, 1);
        Integer ticketNumber = Integer.parseInt(ticketID.substring(1));

        ArrayList<Passenger> businessPassengerList = airplane.getListBusinessPassengers();
        ArrayList<Passenger> economyPassengerList = airplane.getListEconomyPassengers();

        if (ticketClass.equalsIgnoreCase("B")) {

            int arrayIndex = ticketNumber - 1;
            Passenger foundPassenger = businessPassengerList.get(arrayIndex);
            if (businessPassengerList.contains(foundPassenger)) {
                businessPassengerList.remove(foundPassenger);
            }
        }
        else if (ticketClass.equalsIgnoreCase("E")){

            int arrayIndex = ticketNumber - 6;
            Passenger foundPassenger = economyPassengerList.get(arrayIndex);
            if (economyPassengerList.contains(foundPassenger)) {
                businessPassengerList.remove(foundPassenger);
            }
        }
        else {
            System.out.println("Sorry, can\'t find your ticket. Did you spell the ID correctly? Try again.");
        }

        System.out.println("Your reservation is now cancelled. We hope to see you again.");
    }

    public void listAllPassengers(Airplane airplane) {
        ArrayList<Passenger> bList = airplane.getListBusinessPassengers();
        ArrayList<Passenger> eList = airplane.getListEconomyPassengers();

        System.out.println(airplane.toString());

        if (airplane.getTotalNumberOfOccupiedSeats() != 0) {
            if (bList.size() != 0) {
                System.out.println("--- Business passengers ---");
                for (Passenger bp : bList) {
                    System.out.println(bp);
                }
            }
            else {
                // Do nothing!
            }

            if (eList.size() != 0) {
                System.out.println("\n--- Economy passengers ---");
                for (Passenger ep : eList) {
                    System.out.println(ep);
                }
            }
            else {
                // Do nothing!
            }

        } else {
            // Do nothing!
        }
        System.out.println("____________________________________");
    }

    public void showEconomicOverview(Airplane airplane) {
        ArrayList<Passenger> businessPassagerList = airplane.getListBusinessPassengers();
        ArrayList<Passenger> economyPassagerList = airplane.getListEconomyPassengers();

        DecimalFormat df = new DecimalFormat("###,###.##");

        double totalIncome = 0.0;

        for (int i = 0; i < businessPassagerList.size(); i++) {
            totalIncome += businessPassagerList.get(i).getTotalTicketCost();

        }

        for (int i = 0; i < economyPassagerList.size(); i++) {
            totalIncome += economyPassagerList.get(i).getTotalTicketCost();
        }

        StringBuilder sb = new StringBuilder("|------------------\n");
        sb.append("| Total income from flight ");
        sb.append(airplane.getAirplaneName());
        sb.append(" is ");
        sb.append(df.format(totalIncome));
        sb.append(" kr. Total company profit is ");
        sb.append(df.format(totalIncome * 0.30));
        sb.append(" kr.");
        sb.append("\n|__________________\n");

        System.out.println(sb);
    }
}
