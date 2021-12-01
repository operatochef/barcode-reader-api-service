package com.operato.barcodereaderapiservice.resources;

import com.operato.barcodereaderapiservice.data.BarcodeReaderRequestBody;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.operato.barcodereaderapiservice.services.BarcodeReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Path("/")
public class BarcodeReaderResource {

  @Autowired
  private BarcodeReaderService barcodeReaderService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBarcodeReaderResult() {
    return Response.ok(barcodeReaderService.getResult()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response postBarcodeReaderResult(@RequestBody List<BarcodeReaderRequestBody> requestBody) {
    try {
      return Response.ok(barcodeReaderService.getData(requestBody)).build();
    } catch (Exception e) {
      return Response.status(400).entity(e.getMessage()).build();
    }
  }
}
