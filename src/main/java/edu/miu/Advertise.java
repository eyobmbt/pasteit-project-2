package edu.miu;

import java.time.LocalDate;
import java.util.List;

public class Advertise {
    private String advertiseId;
    private String advertiseContent;
    private LocalDate postedDate;

    public Advertise(String advertiseId, String advertiseContent, LocalDate postedDate,
                     LocalDate expireDate, List<AdvertisePasteRecord> advertisePaste) {
        this.advertiseId = advertiseId;
        this.advertiseContent = advertiseContent;
        this.postedDate = postedDate;
        this.expireDate = expireDate;
        this.advertisePaste = advertisePaste;
    }

    private LocalDate expireDate;
    private List<AdvertisePasteRecord> advertisePaste;

}
