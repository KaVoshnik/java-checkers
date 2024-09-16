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

    public boolean makeMove(int fromX, int fromY, int toX, int toY) {
        if (board[fromX][fromY] == WHITE && Math.abs(toX - fromX) == 1 && Math.abs(toY - fromY) == 1 && board[toX][toY] == EMPTY) {
            board[toX][toY] = WHITE;
            board[fromX][fromY] = EMPTY;
            return false;
        } else if (board[fromX][fromY] == BLACK && Math.abs(toX - fromX) == 1 && Math.abs(toY - fromY) == 1 && board[toX][toY] == EMPTY) {
            board[toX][toY] = BLACK;
            board[fromX][fromY] = EMPTY;
            return false;
        } else if (board[fromX][fromY] == WHITE && Math.abs(toX - fromX) == 2 && Math.abs(toY - fromY) == 2 && board[toX][toY] == EMPTY) {
            int midX = (fromX + toX) / 2;
            int midY = (fromY + toY) / 2;
            if (board[midX][midY] == BLACK) {
                board[toX][toY] = WHITE;
                board[fromX][fromY] = EMPTY;
                board[midX][midY] = EMPTY;
                return true;
            }
        } else if (board[fromX][fromY] == BLACK && Math.abs(toX - fromX) == 2 && Math.abs(toY - fromY) == 2 && board[toX][toY] == EMPTY) {
            int midX = (fromX + toX) / 2;
            int midY = (fromY + toY) / 2;
            if (board[midX][midY] == WHITE) {
                board[toX][toY] = BLACK;
                board[fromX][fromY] = EMPTY;
                board[midX][midY] = EMPTY;
                return true;
            }
        } else {
            System.out.println("Not a valid move!");
            return false;
        }
        return false;
    }


    public static void main(String[] args) {
        Checkers game = new Checkers();
        game.printBoard();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your move (For example, a2):");
            String input = scanner.nextLine();
            int fromX = input.charAt(0) - 'a';
            int fromY = input.charAt(1) - '1';
            System.out.println("Enter your move (For example, a4):");
            input = scanner.nextLine();
            int toX = input.charAt(0) - 'a';
            int toY = input.charAt(1) - '1';
        
            if (game.makeMove(fromX, fromY, toX, toY)) {
                System.out.println("Checkers has eliminated!");
            }
        }
    }
}