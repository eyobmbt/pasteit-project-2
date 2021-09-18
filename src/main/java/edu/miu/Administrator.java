package edu.miu;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends Role{
private List<Advertise> advertiseLists;
private List<User> users;


    public Administrator(String roleId) {
        super(roleId);
        this.users = new ArrayList<>();
    }

    public Administrator(List<Advertise> advertiseLists, String roleId) {
        super(roleId);
        this.advertiseLists = advertiseLists;
        this.users = new ArrayList<>();
    }

    public List<Advertise> getAdvertiseLists() {
        return advertiseLists;
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
                "advertiseLists=" + advertiseLists +
                ", users=" + users +
                '}';
    }
}
