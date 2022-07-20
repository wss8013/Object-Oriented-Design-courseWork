package com.company;

public interface ChessPiece {
    int getRow();
    int getColumn();
    String getColor();
    boolean canMove(int row, int col);
    boolean canKill(ChessPiece piece);

    /*
     * Chess board number rule:
     * rows increasing from bottom to top
     * and columns increasing from left to right
     * B represent Black chess piece
     * W represent White chess piece
     *
     *   7   B  B  B  B  B  B  B  B
     *   6   B  B  B  B  B  B  B  B
     *   5
     *   4
     *   3
     *   2
     *   1   W  W  W  W  W  W  W  W
     *   0   W  W  W  W  W  W  W  W
     *       0  1  2  3  4  5  6  7
     * */
}

