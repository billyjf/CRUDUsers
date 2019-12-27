package com.billyjf;

import com.billyjf.api.User;
import com.billyjf.resources.UserResource;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserResourceTest {
    private User billy = new User(1, "Billy", "Fisher", "97078", "billyjfisher@gmail.com");
    private UserResource userResource = new UserResource(List.of(billy));

    @Test
    public void listUsers() {
        assertEquals(List.of(billy), userResource.listUsers());
    }
}
