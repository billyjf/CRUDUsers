package com.billyjf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private long id;
    private String first;
    private String last;
    private String zip;
    private String email;

    public User() { /* Jackson deserialization */ }

    public User(long id, String first, String last, String zip, String email) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.zip = zip;
        this.email = email;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getFirst() {
        return first;
    }

    @JsonProperty
    public String getLast() {
        return last;
    }

    @JsonProperty
    public String getZip() {
        return zip;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }
}
