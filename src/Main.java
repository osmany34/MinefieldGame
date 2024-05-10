import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the number of rows
        System.out.print("Enter number of rows (minimum 2): ");
        int rows = input.nextInt();    // Check if the entered value is less than 2
        if (rows < 2) {
            System.out.println("Error: Number of rows must be at least 2.");
            return;
        }

        // Prompt user to enter the number of columns
        System.out.print("Enter number of columns (minimum 2): ");
        int columns = input.nextInt(); // Check if the entered value is less than 2
        if (columns < 2) {
            // Display error message
            System.out.println("Error: Number of columns must be at least 2.");
            // Exit the program
            return;
        }
        // Create an instance of MineSweeper with user-specified dimensions
        MineSweeper mine = new MineSweeper(rows, columns);
        mine.run();   // Start the game

    }
}
