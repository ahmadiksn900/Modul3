package tugas2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Taxi with a driver name, car model, and availability status.
 */
class Taxi {
    private String driverName;
    private String carModel;
    private boolean isAvailable;

    /**
     * Constructs a Taxi with the specified driver name and car model.
     *
     * @param driverName the name of the driver
     * @param carModel   the model of the car
     */
    public Taxi(String driverName, String carModel) {
        this.driverName = driverName;
        this.carModel = carModel;
        this.isAvailable = true;
    }

    /**
     * Checks if the taxi is available.
     *
     * @return true if the taxi is available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Books the taxi, marking it as unavailable.
     */
    public void book() {
        isAvailable = false;
    }

    /**
     * Completes the ride, marking the taxi as available.
     */
    public void completeRide() {
        isAvailable = true;
    }

    /**
     * Returns a string representation of the taxi.
     *
     * @return a string containing the driver's name and car model
     */
    @Override
    public String toString() {
        return driverName + " - " + carModel;
    }
}

/**
 * Manages a collection of Taxis and handles taxi requests and rides.
 */
class TaxiService {
    private List<Taxi> taxis;

    /**
     * Constructs a TaxiService and initializes it with a list of taxis.
     */
    public TaxiService() {
        taxis = new ArrayList<>();
        taxis.add(new Taxi("John", "Toyota"));
        taxis.add(new Taxi("Doe", "Honda"));
    }

    /**
     * Finds an available taxi.
     *
     * @return an available Taxi, or null if no taxis are available
     */
    public Taxi findAvailableTaxi() {
        for (Taxi taxi : taxis) {
            if (taxi.isAvailable()) {
                return taxi;
            }
        }
        return null;
    }

    /**
     * Requests a taxi and books it if available.
     */
    public void requestTaxi() {
        Taxi taxi = findAvailableTaxi();
        if (taxi != null) {
            System.out.println("Taxi booked: " + taxi);
            taxi.book();
        } else {
            System.out.println("No taxis available.");
        }
    }

    /**
     * Completes a ride for the first booked taxi found.
     */
    public void completeRide() {
        for (Taxi taxi : taxis) {
            if (!taxi.isAvailable()) {
                System.out.println("Ride completed: " + taxi);
                taxi.completeRide();
                return;
            }
        }
        System.out.println("No rides to complete.");
    }
}

/**
 * Main class to run the TaxiService application.
 */
public class Main {
    /**
     * The entry point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        taxiService.requestTaxi();
        taxiService.completeRide();
    }
}
