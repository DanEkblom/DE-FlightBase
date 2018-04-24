package com.danekblom.flightbase.ui;

import com.danekblom.flightbase.controller.BookingManager;
import com.danekblom.flightbase.controller.FleetManager;
import com.danekblom.flightbase.model.Airplane;

import java.util.Scanner;

public class SystemUI {

	// Start the applications UI
	public void start() {

		// Loop-condition
		boolean isRunning = true;

		printWelcomeSplash();
		printMainMenu();

		// Create managers
		BookingManager bookingManager = new BookingManager();
		FleetManager fleetManager = new FleetManager();

		Airplane airplane = new Airplane("SAS SK1276", 5, 5);
		Airplane airplane2 = new Airplane("Luft-Hansa LH7045", 5, 5);
		Airplane airplane3 = new Airplane("Air Berlin AB0562", 5, 5);

		fleetManager.addAirplaneToFleet(airplane);
		fleetManager.addAirplaneToFleet(airplane2);
		fleetManager.addAirplaneToFleet(airplane3);

		// Try-with-resources to auto-close scanner on error or exit
		try(Scanner scanner = new Scanner(System.in)) {

			// Run at least once.
			do {

				// Inner loop error handling
				try {

					// getting manu menu user action
					String keyboard = scanner.next();

					switch (keyboard) {

						case "1":
							//System.out.println("Book a ticket");
							bookingManager.addPassenger(scanner, airplane);
							//printWelcomeSplash();
							printMainMenu();
							break;

						case "2":
							// Show my ticket
							bookingManager.findPassenger(scanner, airplane);
							//printWelcomeSplash();
							printMainMenu();
							break;

						case "3":
							// Cancel a ticket
							bookingManager.cancelTicket(scanner, airplane);
							//printWelcomeSplash();
							printMainMenu();
							break;

						case "4":
							// List all passengers
							bookingManager.listAllPassengers(airplane);
							//printWelcomeSplash();
							printMainMenu();
							break;

						case "5":
							// Show me the monie$
							bookingManager.showEconomicOverview(airplane);
							//printWelcomeSplash();
							printMainMenu();
							break;

						case "6":
							// SList all airplanes in the fleet
							fleetManager.listFleet();
							//printWelcomeSplash();
							printMainMenu();
							break;

						case "0":
							System.out.println("Exiting program...");
							isRunning = false;
							break;

						default:
							System.out.println(keyboard + " is not a valid option. Please try again.");

					}

					// Catch any and all program-specific exceptions here to de-clutter your switch-case
					// in case of checked and/or custom exceptions.

				} catch (Exception e) {
					System.out.println("Exception caught in inner try : " + e.getMessage());

				}

			} while (isRunning);

		} catch (Exception e) {
			System.out.println("Exception caught in outer try : " + e.getMessage());

		} finally {

			// Any tasks needed for cleaning up/saving/etc should be performed here.
			// The scanner auto-closes so don't worry about that.

		}

	}

	/**
	 * Method to show the application screen. called on start only.
	 */
	private void printWelcomeSplash() {
		System.out.println("       |");
		System.out.println("------/|\\------------------------------");
		System.out.println("|    / | \\                            |");
		System.out.println("|   /  |  \\  Welcome to Kite Travel   |");
		System.out.println("|  /   |   \\                          |");
		System.out.println("--/    |    \\--------------------------");
		System.out.println(" /_____|_____\\");
	}

	/**
	 * Method to call the menu. Recurring through the application.
	 */
	private void printMainMenu() {
		System.out.println();
		System.out.println("What do you wish to do today?");
		System.out.println("[1] Book a new ticket.");
		System.out.println("[2] Show my ticket.");
		System.out.println("[3] Cancel my ticket.");
		System.out.println();
		System.out.println("Admin Options:");
		System.out.println("[4] List all passengers.");
		System.out.println("[5] Get economic overview.");
		System.out.println("[6] List fleet airplanes.");
		System.out.println();
		System.out.println("[0] Log out.");
	}


}
