package com.operato.barcodereaderapiservice.data;

public class BarcodeReaderCoordSet {
  private BarcodeReaderCoord pt1;
  private BarcodeReaderCoord pt2;
  private BarcodeReaderCoord pt3;
  private BarcodeReaderCoord pt4;

  public BarcodeReaderCoordSet(BarcodeReaderCoord pt1, BarcodeReaderCoord pt2, BarcodeReaderCoord pt3,
      BarcodeReaderCoord pt4) {
    this.pt1 = pt1;
    this.pt2 = pt2;
    this.pt3 = pt3;
    this.pt4 = pt4;
  }

  public BarcodeReaderCoordSet() {

  }

  public void setPt1(BarcodeReaderCoord pt1) {
    this.pt1 = pt1;
  }

  public BarcodeReaderCoord getPt1() {
    return this.pt1;
  }

  public void setPt2(BarcodeReaderCoord pt2) {
    this.pt2 = pt2;
  }

  public BarcodeReaderCoord getPt2() {
    return this.pt2;
  }

  public void setPt3(BarcodeReaderCoord pt3) {
    this.pt3 = pt3;
  }

  public BarcodeReaderCoord getPt3() {
    return this.pt3;
  }

  public void setPt4(BarcodeReaderCoord pt4) {
    this.pt4 = pt4;
  }

  public BarcodeReaderCoord getPt4() {
    return this.pt4;
  }
}
