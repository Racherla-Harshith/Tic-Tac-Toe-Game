import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        int row, col;
        boolean validMove;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn.");
            System.out.print("Enter row and column (0-2) to make your move: ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            validMove = game.makeMove(row, col);
            if (!validMove) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (game.checkWin()) {
                game.printBoard();
                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                break;
            }

            if (game.isBoardFull()) {
                game.printBoard();
                System.out.println("It's a tie!");
                break;
            }

            game.switchPlayer();
        }

        scanner.close();
    }
}
