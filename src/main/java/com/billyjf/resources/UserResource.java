package com.billyjf.resources;

import com.billyjf.api.User;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/list")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final List<User> users;

    public UserResource(List<User> users) {
        this.users = users;
    }

    @GET
    @Timed
    public List<User> listUsers() {
        return users;
    }
}
