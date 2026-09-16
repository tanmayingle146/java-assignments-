package Assignments;
import java.util.Scanner;

public class Assignment_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double attendance = -1;
        while (attendance < 0 || attendance > 100) {
            System.out.print("Enter attendance percentage (0 - 100): ");
            attendance = scanner.nextDouble();
            if (attendance < 0 || attendance > 100) {
                System.out.println("Invalid input! Attendance must be between 0 and 100.\n");
            }
        }

    
        double marks = -1;
        while (marks < 0 || marks > 100) {
            System.out.print("Enter marks (0 - 100): ");
            marks = scanner.nextDouble();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid input! Marks must be between 0 and 100.\n");
            }
        }


        boolean running = true;
        while (running) {
            System.out.println("\n===== Student Activity Management System =====");
            System.out.println("1. Check Attendance Eligibility");
            System.out.println("2. View Performance Category");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

        
            switch (choice) {
                case 1:
               
                    if (attendance >= 75) {
                        System.out.println("Status: Eligible to appear for the examination.");
                    } else {
                        System.out.println("Status: Not eligible to appear for the examination.");
                    }
                    break;

                case 2:
       
                    if (marks >= 90) {
                        System.out.println("Performance Category: Excellent");
                    } else if (marks >= 70) {
                        System.out.println("Performance Category: Good");
                    } else if (marks >= 60) {
                        System.out.println("Performance Category: Average");
                    } else {
                        System.out.println("Performance Category: Needs Improvement");
                    }
                    break;

                case 3:
                   
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    
                    System.out.println("Invalid choice! Please select a valid option (1-3).");
                    continue;
            }
        }

        scanner.close();
    }
}