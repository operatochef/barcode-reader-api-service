package com.operato.barcodereaderapiservice.services;

import com.operato.barcodereaderapiservice.data.*;
import com.operato.barcodereader.BarcodeReader;
import com.operato.barcodereader.BarcodeReaderData;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class BarcodeReaderService {

  // @Autowired
  // private TaskMapper taskMapper;

  public String getResult() {
    return "Please use POST with the json-fomatted body.";
  }

  public JSONObject getData(List<BarcodeReaderRequestBody> requestBodies) {

    System.out.println("Request Body: ");
    for (BarcodeReaderRequestBody requestBody : requestBodies) {
      System.out.println("Name: " + requestBody.getName());
      System.out.println("Format: " + requestBody.getFormat());
      System.out.println("Data: " + requestBody.getData().length());
      System.out.println("");
    }

    try {
      BarcodeReaderResponseBody responseBody = new BarcodeReaderResponseBody();
      for (BarcodeReaderRequestBody requestBody : requestBodies) {
        String imageData = requestBody.getData();

        BarcodeReaderData barcodeData = BarcodeReader.decodeBase64(imageData);
        System.out.println("Decode result: " + barcodeData.getStatusCode());

        responseBody.addResult(barcodeData);
        if (barcodeData.getStatusCode() == "200") {
          responseBody.incSuccessCount();
        } else {
          responseBody.incFailureCount();
        }
      }

      String barcodeReaderJson = new Gson().toJson(responseBody);
      JSONParser parser = new JSONParser();
      JSONObject barcodeReaderObj = (JSONObject) parser.parse(barcodeReaderJson);
      return barcodeReaderObj;
    } catch (Exception e) {
      System.err.println("Cannot find any barcode: " + e.getMessage());
      return null;
    }
  }
}
