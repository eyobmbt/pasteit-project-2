package edu.miu;

import java.time.LocalDateTime;
import java.util.List;
public class Paste {
    private String pasteId;
    private String content;
    private String title;
    private String url;
    private String description;
    private Language language;
    private Member member;
    private LocalDateTime pasteDateTime;
    private LocalDateTime expiryDateTime;
    private List<Feedback> feedbacks;
    private List<AdvertisePasteRecord> advertisePaste;
    private int numOfViews;
    private int rating;

    public void setNumOfViews(int numOfViews) {
        this.numOfViews = numOfViews;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Member getMember() {
        return member;
    }

    public int getNumOfViews() {
        return numOfViews;
    }

    public int getRating() {
        return rating;
    }

    public Paste(String pasteId) {
        this.pasteId = pasteId;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Paste(String pasteId, String content, String title, String url, String description,
                 Language language, Member member, LocalDateTime pasteDateTime,
                 LocalDateTime expiryDateTime, List<Feedback> feedbacks,
                 List<AdvertisePasteRecord> advertisePaste) {
        this.pasteId = pasteId;
        this.content = content;
        this.title = title;
        this.url = url;
        this.description = description;
        this.language = language;
        this.member = member;
        this.pasteDateTime = pasteDateTime;
        this.expiryDateTime = expiryDateTime;
        this.feedbacks = feedbacks;
        this.advertisePaste = advertisePaste;
    }

    public Paste(String pasteId, String content, String title, Language language, Member member, LocalDateTime pasteDateTime, LocalDateTime expiryDateTime) {
        this.pasteId = pasteId;
        this.content = content;
        this.title = title;
        this.language = language;
        this.member = member;
        this.pasteDateTime = pasteDateTime;
        this.expiryDateTime = expiryDateTime;

    }

    public void setPasteId(String pasteId) {
        this.pasteId = pasteId;
    }

    public String getPasteId() {
        return pasteId;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public Language getLanguage() {
        return language;
    }

    public Member getMemberId() {
        return member;
    }

    public LocalDateTime getPasteDateTime() {
        return pasteDateTime;
    }

    public LocalDateTime getExpiryDateTime() {
        return expiryDateTime;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public List<AdvertisePasteRecord> getAdvertisePaste() {
        return advertisePaste;
    }

    @Override
    public String toString() {
        return "edu.miu.Paste{" +
                "pasteId='" + pasteId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
