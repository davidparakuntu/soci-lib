package com.dav.soci.rest;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/soci")
public class Soci {


    public static void main(String[] args) {
        final String baseUri = "http://localhost:7080/";
        final Map<String, String> initParams = new HashMap<String, String>();

        // Register the package that contains your javax.ws.rs-annotated beans here
        initParams.put("com.sun.jersey.config.property.packages", "com.dav.soci.rest");
        initParams.put("jersey.config.server.provider.packages", "org.codehaus.jackson.jaxrs");

        initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        initParams.put("com.sun.jersey.spi.container.ContainerResponseFilters","com.dav.soci.rest.CORSFilter");

        System.out.println("Starting grizzly...");
        try {
            SelectorThread threadSelector =
                    GrizzlyWebContainerFactory.create(baseUri, initParams);

            System.out.println(String.format("Jersey started with WADL "
                    + "available at %sapplication.wadl.", baseUri));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Well, this was easy!";
    }
}
