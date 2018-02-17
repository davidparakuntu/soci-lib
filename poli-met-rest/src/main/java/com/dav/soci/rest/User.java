package com.dav.soci.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.ObjectWriter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Path("/user")
public class User {
    private static String DATA_PATH="C:\\Users\\dmathias\\Desktop\\soci-lib\\data\\";
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response getUser(com.dav.soci.model.User paramUser){
        String id = paramUser.getId();
        System.out.println("UserID is "+ id);
        if(id == null){
            return Response.status(401).build();
        }
        ObjectReader objectReader = new ObjectMapper().reader(com.dav.soci.model.User.class);
        com.dav.soci.model.User user = null;
        try {
            user = objectReader.readValue(new File("data/"+id));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!user.getPassword().equals(paramUser.getPassword())){
            return Response.status(401).build();
        }
        return Response.ok(user).build();
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
            File userFile = new File(DATA_PATH + id);
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
