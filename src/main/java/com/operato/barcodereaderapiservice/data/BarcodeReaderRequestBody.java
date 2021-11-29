package com.operato.barcodereaderapiservice.data;

public class BarcodeReaderRequestBody {
  private String imageType;
  private String imageData;

  public BarcodeReaderRequestBody(String imageType, String imageData) {
    this.imageType = imageType;
    this.imageData = imageData;
  }

  public BarcodeReaderRequestBody() {
  }

  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  public void setImageData(String imageData) {
    this.imageData = imageData;
  }

  public String getImageType() {
    return this.imageType;
  }

  public String getImageData() {
    return this.imageData;
  }
}