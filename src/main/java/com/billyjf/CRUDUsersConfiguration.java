package com.billyjf;

import com.billyjf.api.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CRUDUsersConfiguration extends Configuration {
    @NotEmpty
    private List<User> users;

    @JsonProperty
    public List<User> getUsers() { return users; }

    @JsonProperty
    public void setUsers(List<User> users) { this.users = users; }
}
