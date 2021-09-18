package edu.miu;

import java.util.List;

public class User {
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private List<Role> roles;


    public User(Long userId, String username, String firstName, String lastName,
                List<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;

    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }
}