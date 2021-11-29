package com.operato.barcodereaderapiservice.services;

import com.operato.barcodereaderapiservice.data.BarcodeReaderRequestBody;
import com.operato.barcodereader.BarcodeReader;
import com.operato.barcodereader.BarcodeReaderData;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class BarcodeReaderService {

    // @Autowired
    // private TaskMapper taskMapper;

    public String getResult() {
        return "Ok";
    }

    public JSONObject getData(BarcodeReaderRequestBody requestBody) {

        // String imageType = requestBody.getImageData();
        String imageData = requestBody.getImageData();

        try {
            BarcodeReaderData barcodeData = BarcodeReader.decodeBase64(imageData);
            String barcodeReaderJson = new Gson().toJson(barcodeData);
            JSONParser parser = new JSONParser();
            JSONObject resultObject = new JSONObject();
            Object barcodeReaderObj = parser.parse(barcodeReaderJson);
            resultObject = (JSONObject) barcodeReaderObj;
            return resultObject;

        } catch (Exception e) {
            System.err.println("Cannot find any barcode: " + e.getMessage());
        }
        return null;
    }
}
