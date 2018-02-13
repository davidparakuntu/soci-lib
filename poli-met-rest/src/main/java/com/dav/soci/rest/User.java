package com.dav.soci.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;

@Path("/user")
public class User {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public com.dav.soci.model.User getUser(@PathParam("id") String userId){
        System.out.println("UserID is "+userId);
        if(userId == null){

            return null;
        }
        ObjectReader objectReader = new ObjectMapper().reader(com.dav.soci.model.User.class);
        com.dav.soci.model.User user = null;
        try {
            user = objectReader.readValue(new File(userId + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
