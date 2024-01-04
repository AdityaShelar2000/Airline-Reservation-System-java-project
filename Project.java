package airline_reservation_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String source, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.availableSeats = totalSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats > 0 && numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println(numSeats + " seat(s) booked successfully for Flight " + flightNumber);
        } else {
            System.out.println("Invalid number of seats or not enough available seats.");
        }
    }
}

class ReservationSystem {
    private List<Flight> flights;

    public ReservationSystem() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println("Flight " + flight.getFlightNumber() + ": " +
                    flight.getSource() + " to " + flight.getDestination() +
                    " - Available Seats: " + flight.getAvailableSeats());
        }
        System.out.println();
    }

    public void bookFlight(String flightNumber, int numSeats) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flight.bookSeats(numSeats);
                return;
            }
        }
        System.out.println("Flight not found with number " + flightNumber);
    }
}

public class Project {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        Flight flight1 = new Flight("01", "Mumbai", "Delhi", 60);
        Flight flight2 = new Flight("02", "Goa", "Jammu", 50);

        reservationSystem.addFlight(flight1);
        reservationSystem.addFlight(flight2);

        Scanner sc = new Scanner(System.in);

        while (true) {
        	System.out.println("==========Airline Jspider==========\n");
            System.out.println("1. Display Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.displayAvailableFlights();
                    break;
                case 2:
                    System.out.print("Enter the flight number: ");
                    String flightNumber = sc.next();
                    System.out.print("Enter the number of seats to book: ");
                    int numSeats = sc.nextInt();
                    reservationSystem.bookFlight(flightNumber, numSeats);
                    break;
                case 3:
                    System.out.println("Accha Theek Hai Milte Hai");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


