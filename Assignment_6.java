package Assignments;


import java.util.Scanner;


class Vehicle {
    private String vehicleType;
    private String vehicleNumber;
    private String vehicleModel;
    private String customerName;
    private int rentalDays;
    private double ratePerDay;

    
    public Vehicle(String vehicleType, String vehicleNumber, String vehicleModel, String customerName, int rentalDays, double ratePerDay) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.customerName = customerName;
        this.rentalDays = rentalDays;
        this.ratePerDay = ratePerDay;
    }
    public String getVehicleType() { return vehicleType; }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getVehicleModel() { return vehicleModel; }
    public String getCustomerName() { return customerName; }
    public int getRentalDays() { return rentalDays; }
    public double getRatePerDay() { return ratePerDay; }

 
    public double calculateRentalCharges() {
        return rentalDays * ratePerDay;
    }


    public void displayDetails() {
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Model          : " + vehicleModel);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Rental Days    : " + rentalDays);
        System.out.printf("Rate Per Day   : ₹%.0f\n", ratePerDay);
    }
}


class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String vehicleNumber, String vehicleModel, String customerName, int rentalDays, int numberOfSeats) {
        super("Car", vehicleNumber, vehicleModel, customerName, rentalDays, 1500.0);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() { return numberOfSeats; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Seats: " + numberOfSeats);
    }
}


class Bike extends Vehicle {
    private String engineCapacity;

    public Bike(String vehicleNumber, String vehicleModel, String customerName, int rentalDays, String engineCapacity) {
        super("Bike", vehicleNumber, vehicleModel, customerName, rentalDays, 700.0);
        this.engineCapacity = engineCapacity;
    }

    public String getEngineCapacity() { return engineCapacity; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity);
    }
}


class Scooter extends Vehicle {
    private String storageCapacity;

    public Scooter(String vehicleNumber, String vehicleModel, String customerName, int rentalDays, String storageCapacity) {
        super("Scooter", vehicleNumber, vehicleModel, customerName, rentalDays, 500.0);
        this.storageCapacity = storageCapacity;
    }

    public String getStorageCapacity() { return storageCapacity; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Storage        : " + storageCapacity);
    }
}


public class Assignment_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle activeRental = null; 

        boolean running = true;
        while (running) {
            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Rent a Bike");
            System.out.println("3. Rent a Scooter");
            System.out.println("4. Display Rental Details");
            System.out.println("5. Calculate Rental Charges");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: { // Rent Car
                    System.out.print("Enter Vehicle Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Rental Days: ");
                    int days = scanner.nextInt();
                    System.out.print("Enter Number of Seats: ");
                    int seats = scanner.nextInt();

                    activeRental = new Car(number, model, name, days, seats);
                    printReceipt(activeRental);
                    break;
                }
                case 2: {
                    System.out.print("Enter Vehicle Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Rental Days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Engine Capacity (e.g., 150cc): ");
                    String engine = scanner.nextLine();

                    activeRental = new Bike(number, model, name, days, engine);
                    printReceipt(activeRental);
                    break;
                }
                case 3: { 
                    System.out.print("Enter Vehicle Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Rental Days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Storage Capacity (e.g., 20L): ");
                    String storage = scanner.nextLine();

                    activeRental = new Scooter(number, model, name, days, storage);
                    printReceipt(activeRental);
                    break;
                }
                case 4: 
                    if (activeRental != null) {
                        System.out.println("\n===== Rental Details =====");
                        activeRental.displayDetails();
                    } else {
                        System.out.println("No active vehicle rental found!");
                    }
                    break;

                case 5: 
                    if (activeRental != null) {
                        System.out.println("\n===== Rental Charge Calculation =====");
                        System.out.println("Vehicle Number : " + activeRental.getVehicleNumber());
                        System.out.printf("Total Amount   : ₹%.0f\n", activeRental.calculateRentalCharges());
                    } else {
                        System.out.println("No active vehicle rental found!");
                    }
                    break;

                case 6: 
                    System.out.println("Exiting Vehicle Rental System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 6.");
            }
        }

        scanner.close();
    }

    
    private static void printReceipt(Vehicle v) {
        System.out.println("\n===== Vehicle Rental Receipt =====");
        System.out.println("Vehicle Type   : " + v.getVehicleType());
        System.out.println("Vehicle Number : " + v.getVehicleNumber());
        System.out.println("Model          : " + v.getVehicleModel());
        System.out.println("Customer Name  : " + v.getCustomerName());
        System.out.println("Rental Days    : " + v.getRentalDays());
        System.out.printf("Rate Per Day   : ₹%.0f\n\n", v.getRatePerDay());
        System.out.printf("Total Amount   : ₹%.0f\n\n", v.calculateRentalCharges());
        System.out.println("Vehicle rented successfully.");
    }
}