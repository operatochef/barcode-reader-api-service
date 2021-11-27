package com.operato.barcodereaderapiservice.config;

import com.operato.barcodereaderapiservice.resources.BarcodeReaderResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(BarcodeReaderResource.class);
    }
}
