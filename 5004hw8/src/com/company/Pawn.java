package com.company;

public class Pawn extends ChessPieceImpl {

  public Pawn(int row, int col, String color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      return false;
    }
    if(this.color.equals("White")) {
      return row == this.row + 1 && col == this.col;
    }else{
      return row == this.row - 1 && col == this.col;
    }
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if(this.color.equals(piece.getColor())) {
      return false;
    }
    // Case black
    if (this.color.equals("Black")) {
      if(this.row - piece.getRow() == 1 && Math.abs(this.col - piece.getColumn()) == 1) {
        return true;
      }
      return false;
    } else {
      // Case white
      if(this.row - piece.getRow() == -1 && Math.abs(this.col - piece.getColumn()) == 1) {
        return true;
      }
      return false;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Pawn)) {
      return false;
    }
    return ((Pawn) obj).getColor().equals(color)
        && ((Pawn) obj).getRow() == row
        && ((Pawn) obj).getColumn() == col;
  }

  @Override
  public int compareTo(Object obj) {
    if (obj == null || !(obj instanceof ChessPiece)) {
      throw new IllegalArgumentException();
    }
    return this.row - ((ChessPiece) obj).getRow();
  }
}
