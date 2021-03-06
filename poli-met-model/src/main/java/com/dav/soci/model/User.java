package com.dav.soci.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class User {

    private String id;
    private Name name;
    private String password;

    private List<Response> responseList;
    private List<Post> postList;

    private List<String> prefferedUsers;

    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<String> getPreffered() {
        return prefferedUsers;
    }

    public void setPreffered(List<String> prefferedUsers) {
        this.prefferedUsers = prefferedUsers;
    }
}
