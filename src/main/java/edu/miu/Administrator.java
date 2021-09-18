package edu.miu;

import java.util.List;

public class Administrator extends Role{
private List<Advertise> advertiseLists;

    public Administrator(String roleId) {
        super(roleId);
    }

    public Administrator(List<Advertise> advertiseLists, String roleId) {
        super(roleId);
        this.advertiseLists = advertiseLists;
    }

    public List<Advertise> getAdvertiseLists() {
        return advertiseLists;
    }
}
