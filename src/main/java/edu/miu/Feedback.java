package edu.miu;

import java.time.LocalDateTime;
public class Feedback {
    private String id;
    private String comment;
    private LocalDateTime dateTime;
    private Paste paste;
    private Long userId;
    private String userName;

    public Feedback(String id, String comment, LocalDateTime dateTime, Paste paste,
                    Long userId, String userName) {
        this.id = id;
        this.comment = comment;
        this.dateTime = dateTime;
        this.paste = paste;
        this.userId = userId;
        this.userName = userName;
    }

    public Feedback(String id, Paste paste) {
        this.id = id;
        this.paste = paste;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaste(Paste paste) {
        this.paste = paste;
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Paste getPaste() {
        return paste;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
