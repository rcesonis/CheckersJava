import java.util.Scanner;

public class CheckersGame {
    private static final int SIZE = 8;
    private Piece[][] board;
    private boolean player1Turn;

    public CheckersGame() {
        board = new Piece[SIZE][SIZE];
        initializeBoard();
        player1Turn = true;
    }

    private void initializeBoard() {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if ((row + col) % 2 != 0) {
                    if (row < 3) {
                        board[row][col] = new Piece(row, col, 'o');
                    } else if (row > 4) {
                        board[row][col] = new Piece(row, col, 'x');
                    }
                }
            }
        }
    }

    public void displayBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == null) {
                    System.out.print(((row + col) % 2 == 0) ? " . " : "   ");
                } else {
                    System.out.print(" " + board[row][col].symbol + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board[fromRow][fromCol];
        return piece != null && piece.isValidMove(toRow, toCol, board);
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board[fromRow][fromCol];
        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = null;
        piece.row = toRow;
        piece.col = toCol;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayBoard();
            System.out.println((player1Turn ? "Player 1 (x)" : "Player 2 (o)") + "'s turn:");
            System.out.print("Enter move (fromRow fromCol toRow toCol): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            if (isValidMove(fromRow, fromCol, toRow, toCol)) {
                movePiece(fromRow, fromCol, toRow, toCol);
                player1Turn = !player1Turn;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        CheckersGame game = new CheckersGame();
        game.play();
    }
}
