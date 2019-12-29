package com.billyjf.resources;

import com.billyjf.api.User;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.ws.rs.core.Response.Status;
import static javax.ws.rs.core.Response.status;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final List<User> users;
    private final AtomicInteger idCounter = new AtomicInteger(2);

    public UserResource(List<User> users) {
        this.users = users;
    }

    @GET
    @Path("/users")
    @Timed
    public List<User> listUsers() {
        return users;
    }

    @POST
    @Path("/users")
    @Consumes({MediaType.APPLICATION_JSON})
    @Timed
    public Response createUser(User user) {
        final User prospectiveUser = new User(idCounter.incrementAndGet(), user.getFirst(), user.getLast(), user.getZip(), user.getEmail());
        Response response = status(Status.OK).build();

        if(users.stream().noneMatch(u -> u.equals(prospectiveUser)))
            users.add(prospectiveUser);
        else
            response = status(Status.CONFLICT).build();

        return response;
    }

    @GET
    @Path("/users/{id}")
    @Timed
    public Object getUser(@PathParam("id") long id) {
        final Optional<User> first = users.stream().filter(u -> u.getId() == id).findFirst();

        if(first.isPresent())
            return first.get();
        else
            return status(Status.NOT_FOUND).build();
    }
}
