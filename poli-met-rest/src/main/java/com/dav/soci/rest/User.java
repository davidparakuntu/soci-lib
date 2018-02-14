package com.dav.soci.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.ObjectWriter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileWriter;
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
            user = objectReader.readValue(new File("data/"+userId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(com.dav.soci.model.User user){
        if(user!= null){
            createOrReplace(user,true);
        }else {
            System.out.println("No user object bound to parameter");
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(com.dav.soci.model.User user){
        if(user!= null){
            createOrReplace(user,false);
        }else {
            System.out.println("No user object bound to parameter");
        }
    }

    private void createOrReplace(com.dav.soci.model.User user, boolean create) {
        String id = user.getId();
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        if(id == null){
            id = user.getContact().getEmailIDs().get(0);
            user.setId(id);
        }
        if(id != null){
            File userFile = new File("data/" + id);
            if(userFile.exists()){
                if(!create){
                    userFile.deleteOnExit();
                    try {
                        writer.writeValue(new FileWriter(userFile), user);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }else{
                if(create) {
                    try {
                        writer.writeValue(new FileWriter(userFile), user);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
