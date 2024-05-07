import java.util.Scanner;

public class MineSweeper {
    private final char[][] field; // Character array representing the game field
    private final char[][] mineLocations; // Character array representing the locations of mines
    private final int rowCount; // Number of rows
    private final int columnCount; // Number of columns
    private int openedCellCount; // Number of opened cells
    private final Scanner input; // Scanner for user input

    // Constructor
    public MineSweeper(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        field = new char[rowCount][columnCount];
        mineLocations = new char[rowCount][columnCount];
        input = new Scanner(System.in);
    }

    // Method to start the game
    public void run() {
        playGame();
    }

    // Method to initialize the game
    private void initializeGame() {
        createField(); // Create the game field
    }

    // Method to randomly place mines
    private void placeMines() {
        int totalMineCount = (rowCount * columnCount) / 4; // Total number of mines
        int placedMineCount = 0; // Number of placed mines

        // Place mines until reaching the total mine count
        while (placedMineCount < totalMineCount) {
            int row = (int) (Math.random() * rowCount); // Random row
            int column = (int) (Math.random() * columnCount); // Random column

            // If there's no mine at this cell, place a mine here
            if (mineLocations[row][column] != '*') {
                mineLocations[row][column] = '*';
                placedMineCount++;
            }
        }
    }

    // Method to create the game field
    private void createField() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                field[i][j] = '-'; // Mark all cells as closed
            }
        }
    }

    // Main method to play the game
    private void playGame() {
        placeMines(); // Place mines
        initializeGame(); // Initialize the game

        boolean playing = true; // Is the game still ongoing?

        while (playing) {
            System.out.println("Welcome to the Minesweeper Game!");
            showMineLocations(); // Show mine locations
            showGameField(); // Show the game field
            System.out.print("Enter Row: ");
            int row = input.nextInt(); // Get row input from the user
            System.out.print("Enter Column: ");
            int column = input.nextInt(); // Get column input from the user

            // Is the entered coordinate valid?
            if (!isValid(row, column)) {
                System.out.println("Invalid coordinate. Please try again.");
                continue;
            }

            // Is there a mine at the entered coordinate?
            if (isMine(row, column)) {
                showGameField();
                System.out.println("Game Over!!");
                showMineLocations();
                playing = false;
            } else {
                openCell(row, column); // Open the cell
                if (isGameWon()) { // Did the player win the game?
                    showGameField();
                    System.out.println("Congratulations! You won the game!");
                    playing = false;
                }
            }
        }
    }

    // Method to check if the given coordinate is valid
    private boolean isValid(int row, int column) {
        return row >= 0 && row < rowCount && column >= 0 && column < columnCount && field[row][column] == '-';
    }

    // Method to check if there is a mine at the given coordinate
    private boolean isMine(int row, int column) {
        return mineLocations[row][column] == '*';
    }

    // Method to open a cell
    private void openCell(int row, int column) {
        if (mineLocations[row][column] == '*') {
            field[row][column] = '*'; // If there is a mine, mark the cell
            return;
        }

        int adjacentMineCount = 0; // Count of adjacent mines
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newColumn = column + j;
                if (newRow >= 0 && newRow < rowCount && newColumn >= 0 && newColumn < columnCount
                        && mineLocations[newRow][newColumn] == '*') {
                    adjacentMineCount++; // If there's a mine in the adjacent cell, increment the counter
                }
            }
        }
        field[row][column] = Character.forDigit(adjacentMineCount, 10); // Update the cell with the adjacent mine count
        openedCellCount++; // Increment the count of opened cells

        if (adjacentMineCount == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newColumn = column + j;
                    if (newRow >= 0 && newRow < rowCount && newColumn >= 0 && newColumn < columnCount
                            && field[newRow][newColumn] == '-') {
                        openCell(newRow, newColumn); // Recursively open adjacent cells if they are closed
                    }
                }
            }
        }
    }

    // Method to check if the player has won the game
    private boolean isGameWon() {
        return openedCellCount == (rowCount * columnCount) - ((rowCount * columnCount) / 4);
    }

    // Method to show the game field
    private void showGameField() {
        System.out.println("===========================");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }

    // Method to show mine locations
    private void showMineLocations() {
        System.out.println("Mine Locations");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.print(mineLocations[i][j] + " ");
            }
            System.out.println();
        }
    }
}
