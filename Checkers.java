import java.util.Scanner;

public class Checkers {
    private static final int SIZE = 8;
    private static final char EMPTY = '-';
    private static final char WHITE = 'W';
    private static final char BLACK = 'B';

    private final char[][] board = new char[SIZE][SIZE];

    public Checkers() {
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) % 2 == 1) {
                    if (i < 3) {
                        board[i][j] = BLACK;
                    } else if (i > 4) {
                        board[i][j] = WHITE;
                    } else {
                        board[i][j] = EMPTY;
                    }
                } else {
                    board[i][j] = EMPTY;
                }
            }
        }
    }

    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(int fromX, int fromY, int toX, int toY) {
        if (board[fromX][fromY] == WHITE && (toX == fromX + 1 || toX == fromX - 1) && (toY == fromY + 1 || toY == fromY - 1) && board[toX][toY] == EMPTY) {
            board[toX][toY] = WHITE;
            board[fromX][fromY] = EMPTY;
        } else if (board[fromX][fromY] == BLACK && (toX == fromX + 1 || toX == fromX - 1) && (toY == fromY + 1 || toY == fromY - 1) && board[toX][toY] == EMPTY) {
            board[toX][toY] = BLACK;
            board[fromX][fromY] = EMPTY;
        } else {
            System.out.println("Not a valid move!");
        }
    }

    public static void main(String[] args) {
        Checkers game = new Checkers();
        game.printBoard();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your move (For example, a2):");
            String input = scanner.nextLine();
            int fromX = input.charAt(1) - '1';
            int fromY = input.charAt(0) - 'a';
            System.out.println("Enter your move (For example, a4):");
            input = scanner.nextLine();
            int toX = input.charAt(1) - '1';
            int toY = input.charAt(0) - 'a';
            game.makeMove(fromX, fromY, toX, toY);
            game.printBoard();
        }
    }
}