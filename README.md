# Minefield Game

This is a console-based implementation of the classic Minesweeper game written in Java.

## Technologies Used

- Java programming language
- IntelliJ IDEA (IDE)


## How to Play
1. Run the program.
2. Enter the number of rows and columns for the game grid.
3. The game will randomly place mines on the grid.
4. Players take turns entering coordinates to uncover cells.
5. If a mine is uncovered, the game ends.
6. If all non-mine cells are uncovered, the player wins.

## Rules
- The game is text-based.
- The project must utilize two-dimensional arrays.
- The `MineSweeper` class should be used to encapsulate the game logic.
- Player-entered coordinates must be within the grid bounds.
- If a mine is uncovered, the game ends.
- The number of adjacent mines is displayed on uncovered cells.

## Features
- Customizable grid size.
- Random mine placement.
- User-friendly interface with clear prompts and messages.
- Win and lose conditions.

## Usage
1. Clone the repository to your local machine.
2. Compile the `MineSweeper.java` file using a Java compiler.
3. Run the compiled program.
4. Follow the on-screen prompts to play the game.

## Sample Gameplay

Enter number of rows (minimum 2): 3

Enter number of columns (minimum 2): 4

Welcome to MineSweeper Game!

Enter the number of rows: 4

Enter the number of columns: 4

Game started!

| - | - | - | - |
| - | - | - | - |
| - | - | - | - |
| - | - | - | - |


Enter row (0-3): 2

Enter column (0-3): 2

Uncovered cell: 0

| - | - | - | - |
| - | - | - | - |
| - | - | 1| - |
| - | - | - | - |


...

Game Over! You hit a mine!

Would you like to play again? (yes/no): no

Thanks for playing!

