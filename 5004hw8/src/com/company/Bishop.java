package com.company;

public class Bishop extends ChessPieceImpl {

  public Bishop(int row, int col, String color) {
    super(row,col,color);
  }

  // out of range row,col return false or throw exception
  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }
    return Math.abs(this.row - row) == Math.abs(this.col - col);
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (piece.getColor().equals(color)) {
      return false;
    }
    return canMove(piece.getRow(), piece.getColumn());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Bishop)) {
      return false;
    }
    return ((Bishop) obj).getColor().equals(color)
        && ((Bishop) obj).getRow() == row
        && ((Bishop) obj).getColumn() == col;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj == null || !(obj instanceof ChessPiece)) {
      throw new IllegalArgumentException();
    }
    return this.row - ((ChessPiece) obj).getRow();
  }
}
