package com.billyjf;

import com.billyjf.api.User;
import com.billyjf.resources.UserResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.Response.Status;
import static org.junit.Assert.assertEquals;

public class UserResourceTest {
    private User billy = new User(1, "Billy", "Fisher", "97078", "billyjfisher@gmail.com");
    private UserResource userResource;

    public UserResourceTest() {
        List<User> users = new ArrayList<User>();
        users.add(billy);
        userResource = new UserResource(users);
    }

    @Test
    public void listUsers() {
        assertEquals(List.of(billy), userResource.listUsers());
    }

    @Test
    public void createUser() {
        User janTheMan = new User(2, "Jan", "Spooner", "12345", "jantheman@someprovider.com");
        userResource.createUser(janTheMan);

        assertEquals(janTheMan, userResource.listUsers().get(1));
    }

    @Test
    public void createUserReturnsConflictOnDuplicate() {
        User janTheMan = new User(2, "Jan", "Spooner", "12345", "jantheman@someprovider.com");
        userResource.createUser(janTheMan);

        assertEquals(Status.CONFLICT.getStatusCode(), userResource.createUser(janTheMan).getStatus());
    }
}
