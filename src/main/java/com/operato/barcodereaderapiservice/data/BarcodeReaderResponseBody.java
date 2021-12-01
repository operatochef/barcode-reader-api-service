package com.operato.barcodereaderapiservice.data;

import com.operato.barcodereader.BarcodeReaderData;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class BarcodeReaderResponseBody implements Serializable {
  private int success_count = 0;
  private int failure_count = 0;
  private List<BarcodeReaderData> result = new ArrayList<BarcodeReaderData>();

  public BarcodeReaderResponseBody(int success_count, int failure_count, List<BarcodeReaderData> result) {
    this.success_count = success_count;
    this.failure_count = failure_count;
    this.result = result;
  }

  public BarcodeReaderResponseBody() {
  }

  public void setResult(List<BarcodeReaderData> result) {
    this.result = result;
  }

  public List<BarcodeReaderData> getResult() {
    return this.result;
  }

  public void addResult(BarcodeReaderData barcodeReaderData) {
    this.result.add(barcodeReaderData);
  }

  public void setSuccessCount(int success_count) {
    this.success_count = success_count;
  }

  public int getSuccessCount() {
    return this.success_count;
  }

  public void incSuccessCount() {
    this.success_count++;
  }

  public void setFailureCount(int failure_count) {
    this.failure_count = failure_count;
  }

  public int getFailureCount() {
    return this.failure_count;
  }

  public void incFailureCount() {
    this.failure_count++;
  }

  public String toString() {
    String resultString = "";
    for (BarcodeReaderData barcodeReaderResult : this.result) {
      resultString += barcodeReaderResult.toString();
      resultString += "\n";
    }

    return "success_count: " + success_count + ", failure_count: " + failure_count + ", result: " + resultString;
  }

}
