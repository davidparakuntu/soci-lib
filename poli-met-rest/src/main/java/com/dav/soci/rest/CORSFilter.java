package com.dav.soci.rest;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CORSFilter implements ContainerResponseFilter{
    public ContainerResponse filter(ContainerRequest containerRequest, ContainerResponse containerResponse) {
        System.out.println("Filter get called");
        containerResponse.getHttpHeaders().add("Access-Control-Allow-Origin","*");
        return containerResponse;
    }
}
