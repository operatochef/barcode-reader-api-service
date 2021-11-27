package com.operato.barcodereaderapiservice.resources;

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
    public Response postBarcodeReaderResult() {
        return Response.ok(barcodeReaderService.getData()).build();
    }

    // @GET
    // @Path("{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getTask(@PathParam("id") Long id) {
    // if (id == null) {
    // return Response.ok(taskService.getTasks()).build();
    // }
    // final Optional<TaskDTO> task = taskService.getTask(id);
    // if (task.isEmpty()) {
    // return Response.status(Response.Status.NOT_FOUND).build();
    // }
    // return Response.ok(task).build();
    // }

    // @POST
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response createTask(@Valid TaskDTO task) {
    // return Response.ok(taskService.createTask(task)).build();
    // }
}
