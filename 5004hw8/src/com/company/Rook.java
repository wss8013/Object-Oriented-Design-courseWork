package com.company;

public class Rook extends ChessPieceImpl{

  public Rook(int row, int col, String color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // out of range
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }
    // not horizontal nor vertical
    if(row != this.row && col != this.col) {
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
    if (obj == null || !(obj instanceof Rook)) {
      return false;
    }
    return ((Rook) obj).getColor().equals(color)
        && ((Rook) obj).getRow() == row
        && ((Rook) obj).getColumn() == col;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj == null || !(obj instanceof ChessPiece)) {
      throw new IllegalArgumentException();
    }
    return this.row - ((ChessPiece) obj).getRow();
  }
}