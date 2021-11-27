package com.operato.barcodereaderapiservice.services;

import com.operato.barcodereaderapiservice.data.BarcodeReaderCoord;
import com.operato.barcodereaderapiservice.data.BarcodeReaderCoordSet;
import com.operato.barcodereaderapiservice.data.BarcodeReaderData;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class BarcodeReaderService {

    // @Autowired
    // private TaskMapper taskMapper;

    public String getResult() {
        return "1000";
    }

    public JSONObject getData() {
        BarcodeReaderData barcodeData = new BarcodeReaderData();

        List<String> aaa = new ArrayList<String>();
        aaa.add("first");

        // BarcodeReaderCoord coord1 = new BarcodeReaderCoord(10, 10);
        // BarcodeReaderCoord coord2 = new BarcodeReaderCoord(10, 10);
        // BarcodeReaderCoord coord3 = new BarcodeReaderCoord(10, 10);
        // BarcodeReaderCoord coord4 = new BarcodeReaderCoord(10, 10);

        BarcodeReaderCoordSet coordSet = new BarcodeReaderCoordSet(
                new BarcodeReaderCoord(0, 0),
                new BarcodeReaderCoord(0, 10),
                new BarcodeReaderCoord(10, 0),
                new BarcodeReaderCoord(10, 10));

        List<BarcodeReaderCoordSet> listCoordSet = new ArrayList<BarcodeReaderCoordSet>();
        listCoordSet.add(coordSet);

        barcodeData.setBoundaries(listCoordSet);
        barcodeData.setTexts(aaa);

        String barcodeReaderJson = new Gson().toJson(barcodeData);

        JSONParser parser = new JSONParser();

        JSONObject resultObject = new JSONObject();
        try {
            Object barcodeReaderObj = parser.parse(barcodeReaderJson);
            resultObject = (JSONObject) barcodeReaderObj;
        } catch (ParseException ex) {

        }
        return resultObject;
    }
}
