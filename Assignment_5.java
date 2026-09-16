package Assignments;
import java.util.Scanner;

class Room {
  
    private int roomNumber;
    private String roomType;
    private String customerName;
    private int numberOfDays;
    private double pricePerDay;
    private boolean isBooked;

   
    private static int totalBookings = 0;

  
    public Room(int roomNumber, String roomType, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.customerName = "N/A";
        this.numberOfDays = 0;
        this.isBooked = false;
    }


    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public String getCustomerName() { return customerName; }
    public int getNumberOfDays() { return numberOfDays; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isBooked() { return isBooked; }
    public static int getTotalBookings() { return totalBookings; }

    
    public void bookRoom(String customerName, int numberOfDays) {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " is already booked!");
            return;
        }
        this.customerName = customerName;
        this.numberOfDays = numberOfDays;
        this.isBooked = true;
        totalBookings++;

        System.out.println("\n===== Booking Confirmation =====");
        System.out.println("Room Number   : " + roomNumber);
        System.out.println("Room Type     : " + roomType);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Number of Days: " + numberOfDays);
        System.out.printf("Price Per Day : ₹%.0f\n\n", pricePerDay);
        System.out.printf("Total Bill    : ₹%.0f\n\n", calculateBill());
        System.out.println("Room booked successfully.");
    }

    public void cancelBooking() {
        if (!isBooked) {
            System.out.println("Room " + roomNumber + " is not currently booked.");
            return;
        }
        this.customerName = "N/A";
        this.numberOfDays = 0;
        this.isBooked = false;
        totalBookings--;
        System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
    }

    public double calculateBill() {
        return numberOfDays * pricePerDay;
    }

    public void displayRoomDetails() {
        System.out.println("Room Number   : " + roomNumber);
        System.out.println("Room Type     : " + roomType);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Number of Days: " + numberOfDays);
        System.out.printf("Price Per Day : ₹%.0f\n", pricePerDay);
        System.out.println("Status        : " + (isBooked ? "Booked" : "Available"));
    }
}

public class Assignment_5 {

    
    private static Room findRoom(Room[] rooms, int roomNum) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNum) {
                return r;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        Room[] rooms = {
            new Room(101, "Standard", 2000),
            new Room(205, "Deluxe", 3500),
            new Room(301, "Premium", 5000)
        };

        boolean running = true;
        while (running) {
            System.out.println("\n===== Hotel Room Booking System =====");
            System.out.println("1. Book Room");
            System.out.println("2. Display Room Details");
            System.out.println("3. Calculate Bill");
            System.out.println("4. Check Room Status");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Display Total Bookings");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Number (101, 205, 301): ");
                    int bookNum = scanner.nextInt();
                    Room bookRoom = findRoom(rooms, bookNum);
                    if (bookRoom != null) {
                        if (bookRoom.isBooked()) {
                            System.out.println("Room " + bookNum + " is already booked!");
                        } else {
                            scanner.nextLine();
                            System.out.print("Enter Customer Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Number of Days: ");
                            int days = scanner.nextInt();
                            bookRoom.bookRoom(name, days);
                        }
                    } else {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int detailNum = scanner.nextInt();
                    Room detailRoom = findRoom(rooms, detailNum);
                    if (detailRoom != null) {
                        System.out.println("\n--- Room Details ---");
                        detailRoom.displayRoomDetails();
                    } else {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int billNum = scanner.nextInt();
                    Room billRoom = findRoom(rooms, billNum);
                    if (billRoom != null) {
                        if (billRoom.isBooked()) {
                            System.out.printf("Total Bill for Room %d: ₹%.0f\n", billNum, billRoom.calculateBill());
                        } else {
                            System.out.println("Room " + billNum + " is not booked yet.");
                        }
                    } else {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Room Number: ");
                    int statusNum = scanner.nextInt();
                    Room statusRoom = findRoom(rooms, statusNum);
                    if (statusRoom != null) {
                        System.out.println("Room " + statusNum + " Status: " + (statusRoom.isBooked() ? "Booked" : "Available"));
                    } else {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Room Number: ");
                    int cancelNum = scanner.nextInt();
                    Room cancelRoom = findRoom(rooms, cancelNum);
                    if (cancelRoom != null) {
                        cancelRoom.cancelBooking();
                    } else {
                        System.out.println("Invalid Room Number!");
                    }
                    break;

                case 6:
                    System.out.println("Total Active Bookings across all rooms: " + Room.getTotalBookings());
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option (1-7).");
            }
        }

        scanner.close();
    }
}