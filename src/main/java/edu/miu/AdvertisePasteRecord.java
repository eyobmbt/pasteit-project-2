package edu.miu;

public class AdvertisePasteRecord {
    private Paste paste;
    private Advertise advertise;

    public AdvertisePasteRecord(Paste paste, Advertise advertise) {
        this.paste = paste;
        this.advertise = advertise;
    }

    public Paste getPaste() {
        return paste;
    }

    public Advertise getAdvertise() {
        return advertise;
    }
}
