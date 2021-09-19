package edu.miu;

import java.time.LocalDate;
import java.util.List;

public class Member extends Role{
    private LocalDate subscribedDate;
    private LocalDate expireDate;
    private List<Paste> pasteList;

    public Member(LocalDate subscribedDate, LocalDate expireDate, String roleId) {
        super(roleId);
        this.subscribedDate = subscribedDate;
        this.expireDate = expireDate;
    }

    public List<Paste> getPasteList() {
        return pasteList;
    }

    public void setPasteList(List<Paste> pasteList) {
        this.pasteList = pasteList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "subscribedDate=" + subscribedDate +
                ", expireDate=" + expireDate +
                ", pasteList=" + pasteList +
                '}';
    }

    public LocalDate getSubscribedDate() {
        return subscribedDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
}
