package com.operato.barcodereaderapiservice.data;

public class BarcodeReaderRequestBody {
  private String format;
  private String data;
  private String name;

  public BarcodeReaderRequestBody(String format, String data, String name) {
    this.format = format;
    this.data = data;
    this.name = name;
  }

  public BarcodeReaderRequestBody() {
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFormat() {
    return this.format;
  }

  public String getData() {
    return this.data;
  }

  public String getName() {
    return this.name;
  }
}