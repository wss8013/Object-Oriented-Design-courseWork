package com.company;

public class Queen extends ChessPieceImpl {

  public Queen(int row, int col, String color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }
    // not horizontal nor vertical
    // or not diagonal
    if(row != this.row && col != this.col && Math.abs(this.row - row) != Math.abs(this.col - col)) {
      return false;
    }
    return true;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece.getColor().equals(color)) {
      return false;
    }
    return canMove(piece.getRow() ,piece.getColumn());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Queen)) {
      return false;
    }
    return ((Queen) obj).getColor().equals(color)
        && ((Queen) obj).getRow() == row
        && ((Queen) obj).getColumn() == col;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj == null || !(obj instanceof ChessPiece)) {
      throw new IllegalArgumentException();
    }
    return this.row - ((ChessPiece) obj).getRow();
  }
}
