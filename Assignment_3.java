package Assignments;
public class Assignment_3 {

    public static int calculateTotal(int[] row) {
        int total = 0;
        for (int rating : row) {
            total += rating;
        }
        return total;
    }

    
    public static int calculateTotal(int[][] ratings, int partnerIndex) {
        return calculateTotal(ratings[partnerIndex]);
    }

    
    public static double calculateAverage(int total, int count) {
        return (double) total / count;
    }


    public static double calculateAverage(int[] row) {
        int total = calculateTotal(row);
        return calculateAverage(total, row.length);
    }

    
    public static boolean linearSearch(int[][] ratings, int target) {
        for (int i = 0; i < ratings.length; i++) {
            for (int j = 0; j < ratings[i].length; j++) {
                if (ratings[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void bubbleSort(String[] partners, int[] totals) {
        int n = totals.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (totals[j] < totals[j + 1]) {
              
                    int tempTotal = totals[j];
                    totals[j] = totals[j + 1];
                    totals[j + 1] = tempTotal;

                    String tempPartner = partners[j];
                    partners[j] = partners[j + 1];
                    partners[j + 1] = tempPartner;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] ratings = {
            {4, 5, 4, 5}, 
            {3, 4, 5, 4}, 
            {5, 5, 5, 5}, 
            {4, 3, 4, 3}, 
            {5, 4, 5, 4}
        };

        String[] partners = {"Partner 1", "Partner 2", "Partner 3", "Partner 4", "Partner 5"};
        int[] totals = new int[ratings.length];

        System.out.println("===== Food Delivery Rating Analysis =====\n");

      
        for (int i = 0; i < ratings.length; i++) {
            totals[i] = calculateTotal(ratings, i);
            double average = calculateAverage(ratings[i]);

            System.out.println(partners[i] + " Total   : " + totals[i]);
            System.out.printf("%s Average : %.2f\n\n", partners[i], average);
        }

      
        int targetRating = 5;
        boolean isFound = linearSearch(ratings, targetRating);
        System.out.println("Linear Search: Is rating " + targetRating + " found? " + isFound);

        
        bubbleSort(partners, totals);

        
        System.out.println("\n===== Ranking =====\n");
        for (int i = 0; i < partners.length; i++) {
            System.out.println((i + 1) + ". " + partners[i]);
        }

        System.out.println("\nHighest Rated Partner: " + partners[0]);
    }
}