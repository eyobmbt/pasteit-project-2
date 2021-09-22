package edu.miu;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends Role{

private List<User> users;


    public Administrator( String roleId) {
        super(roleId);
        this.users = new ArrayList<>();
    }



    public void addUsers(List<User> listOfUser) {
        this.users.addAll(listOfUser);
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                ", users=" + users +
                '}';
    }
}
