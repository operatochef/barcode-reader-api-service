package com.operato.barcodereaderapiservice.data;

public class BarcodeReaderCoord {
  private int x;
  private int y;

  public BarcodeReaderCoord(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public BarcodeReaderCoord() {
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}