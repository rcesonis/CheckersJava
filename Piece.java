public class Piece {
    public int row;
    public int col;
    public char symbol;

    public Piece(int row, int col, char symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public boolean isValidMove(int toRow, int toCol, Piece[][] board) {
        if (board[toRow][toCol] == null) {
            if (symbol == 'x') {
                return toRow == row - 1 && Math.abs(toCol - col) == 1;
            } else if (symbol == 'o') {
                return toRow == row + 1 && Math.abs(toCol - col) == 1;
            }
        }
        return false;
    }
}
