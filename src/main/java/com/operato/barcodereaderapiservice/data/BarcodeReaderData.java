package com.operato.barcodereaderapiservice.data;

import java.util.List;
import java.io.Serializable;

public class BarcodeReaderData implements Serializable {
  private List<BarcodeReaderCoordSet> boundaries;
  private List<String> texts;

  public BarcodeReaderData(List<BarcodeReaderCoordSet> boundaries, List<String> texts) {
    this.boundaries = boundaries;
    this.texts = texts;
  }

  public BarcodeReaderData() {
  }

  public void setBoundaries(List<BarcodeReaderCoordSet> boundaries) {
    this.boundaries = boundaries;
  }

  public List<BarcodeReaderCoordSet> getBoundaries() {
    return this.boundaries;
  }

  public void setTexts(List<String> texts) {
    this.texts = texts;
  }

  public List<String> getTexts() {
    return this.texts;
  }

  @Override
  public String toString() {
    return "{texts: [\"hi\"], boundaries: [\"nope\"]";
  }
}
