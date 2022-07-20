package com.company;

public class Knight extends ChessPieceImpl{

  public Knight(int row, int col, String color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }
    int rowDiff = Math.abs(this.row - row);
    int colDiff = Math.abs(this.col - col);
    if((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
      return true;
    }
    return false;
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
    if (obj == null || !(obj instanceof Knight)) {
      return false;
    }
    return ((Knight) obj).getColor().equals(color)
        && ((Knight) obj).getRow() == row
        && ((Knight) obj).getColumn() == col;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj == null || !(obj instanceof ChessPiece)){
      throw new IllegalArgumentException();
    }
    return this.row - ((ChessPiece) obj).getRow();
  }
}
