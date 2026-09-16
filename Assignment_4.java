package Assignments;
import java.util.Scanner;

public class Assignment_4 {

  
    public static void displayAllMarks(String[] students, String[] subjects, int[][] marks) {
        System.out.println("\n--- All Student Marks ---");
        System.out.printf("%-12s %-8s %-8s %-8s\n", "Student", subjects[0], subjects[1], subjects[2]);
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-12s %-8d %-8d %-8d\n", students[i], marks[i][0], marks[i][1], marks[i][2]);
        }
    }

  
    public static int[] calculateTotals(int[][] marks) {
        int[] totals = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            int sum = 0;
            for (int j = 0; j < marks[i].length; j++) {
                sum += marks[i][j];
            }
            totals[i] = sum;
        }
        return totals;
    }

    
    public static void displayTotalsAndAverages(String[] students, int[][] marks, int[] totals) {
        System.out.println("\n--- Student Totals & Averages ---");
        for (int i = 0; i < students.length; i++) {
            double average = (double) totals[i] / marks[i].length;
            System.out.println(students[i] + " Total   : " + totals[i]);
            System.out.printf("%s Average : %.2f\n\n", students[i], average);
        }
    }

  
    public static void findHighestScorer(String[] students, String[] subjects, int[][] marks, int[] totals) {
        System.out.println("\n--- Highest Marks & Highest Scorer ---");

    
        for (int j = 0; j < subjects.length; j++) {
            int maxMark = marks[0][j];
            for (int i = 1; i < marks.length; i++) {
                if (marks[i][j] > maxMark) {
                    maxMark = marks[i][j];
                }
            }
            System.out.printf("Highest %-7s Marks : %d\n", subjects[j], maxMark);
        }

     
        int maxIndex = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > totals[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("\nHighest Scorer: " + students[maxIndex]);
    }


    public static void searchMark(int[][] marks, int target) {
        boolean found = false;
        System.out.println("\n--- Search Results ---");
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                if (marks[i][j] == target) {
                    System.out.println("Mark " + target + " found in Student " + (i + 1) + ", Subject " + (j + 1));
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Mark " + target + " was not found in the records.");
        }
    }

   
    public static void sortStudentTotals(String[] students, int[] totals) {
        String[] sortedStudents = students.clone();
        int[] sortedTotals = totals.clone();

        int n = sortedTotals.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedTotals[j] < sortedTotals[j + 1]) {
                    // Swap totals
                    int tempTotal = sortedTotals[j];
                    sortedTotals[j] = sortedTotals[j + 1];
                    sortedTotals[j + 1] = tempTotal;

      
                    String tempStudent = sortedStudents[j];
                    sortedStudents[j] = sortedStudents[j + 1];
                    sortedStudents[j + 1] = tempStudent;
                }
            }
        }

        System.out.println("\n--- Sorted Student Totals (Highest to Lowest) ---");
        for (int i = 0; i < sortedTotals.length; i++) {
            System.out.println((i + 1) + ". " + sortedStudents[i] + " - Total: " + sortedTotals[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = {"Student 1", "Student 2", "Student 3", "Student 4", "Student 5"};
        String[] subjects = {"Java", "Python", "DBMS"};

        int[][] marks = {
            {78, 82, 75}, 
            {90, 85, 88},
            {65, 72, 70}, 
            {88, 91, 85}, 
            {55, 60, 58}  
        };

    
        int[] totals = calculateTotals(marks);

        boolean running = true;
        while (running) {
            System.out.println("\n===== Student Marks Management System =====");
            System.out.println("1. Display All Marks");
            System.out.println("2. Display Student Totals & Averages");
            System.out.println("3. Find Highest Scorer & Subject-Wise Max");
            System.out.println("4. Search Marks");
            System.out.println("5. Sort Student Totals");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllMarks(students, subjects, marks);
                    break;
                case 2:
                    displayTotalsAndAverages(students, marks, totals);
                    break;
                case 3:
                    findHighestScorer(students, subjects, marks, totals);
                    break;
                case 4:
                    System.out.print("Enter mark to search: ");
                    int target = scanner.nextInt();
                    searchMark(marks, target);
                    break;
                case 5:
                    sortStudentTotals(students, totals);
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 6.");
            }
        }

        scanner.close();
    }
}