package com.company;

public abstract class ChessPieceImpl implements ChessPiece, Comparable {
  protected int row;
  protected int col;
  protected String color;

  public ChessPieceImpl(int row, int col, String color) {
    setCol(col);
    setRow(row);
    setColor(color);
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return col;
  }

  @Override
  public String getColor() {
    return color;
  }

  protected  void setRow(int row) {
    if (row < 0 || row > 7) {
      throw new IllegalArgumentException();
    }
    this.row = row;
  }

  protected void setCol(int col) {
    if (col < 0 || col > 7) {
      throw new IllegalArgumentException();
    }
    this.col = col;
  }

  protected void setColor(String color) {
    if (!color.equals("White") && !color.equals("Black")) {
      throw new IllegalArgumentException();
    }
    this.color = color;
  }

  @Override
  public abstract boolean canMove(int row, int col);

  @Override
  public abstract boolean canKill(ChessPiece piece);

  @Override
  public abstract int compareTo(Object obj);
}
