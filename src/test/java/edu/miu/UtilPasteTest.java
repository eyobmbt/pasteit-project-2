package edu.miu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class UtilPasteTest {
    private Role admin;
    public Role member1;
    public Role member2;
    public Role member3;
    public Role member4;
    public Role member5;


    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;

    private Feedback feedback1;
    private Feedback feedback2;
    private Feedback feedback3;
    private Feedback feedback4;
    private Feedback feedback5;
    private Feedback feedback6;
    private Feedback feedback7;
    private Feedback feedback8;
    private Feedback feedback9;
    private Feedback feedback10;
    private Feedback feedback11;
    private Feedback feedback12;
    private Feedback feedback13;
    private Feedback feedback14;
    private Feedback feedback15;
    private Feedback feedback16;

    private Paste paste1;
    private Paste paste2;
    private Paste paste3;
    private Paste paste4;
    private Paste paste5;
    List<Paste> pasteListMember1 = new ArrayList<>();
    List<Paste> pasteListMember2 = new ArrayList<>();
    List<Paste> pasteListMember3 = new ArrayList<>();
    List<Paste> pasteListMember4 = new ArrayList<>();

    List<Feedback> feedbackListPaste1 = new ArrayList<>();
    List<Feedback> feedbackListPaste2 = new ArrayList<>();
    List<Feedback> feedbackListPaste3 = new ArrayList<>();
    List<Feedback> feedbackListPaste4 = new ArrayList<>();
    List<Feedback> feedbackListPaste5 = new ArrayList<>();

    List<User> listOfUser = new ArrayList<>();

    @BeforeEach
    void setup() {

        member1 = new Member(LocalDate.now().minusYears(1l), LocalDate.now().plusDays(30l), "111");
        member2 = new Member(LocalDate.now(), LocalDate.now().plusDays(2l), "222");
        member3 = new Member(LocalDate.now().minusYears(3l), LocalDate.now().plusDays(4l), "333");
        member4 = new Member(LocalDate.now(), LocalDate.now().plusDays(1l), "444");
        member5 = new Member(LocalDate.now(), LocalDate.now().plusDays(1l), "555");

        user1 = new User(111l, "abdi", "Abdi", "Wako", List.of(member1));
        user2 = new User(222l, "eyob", "Eyob", "Beyene", List.of(member2));
        user3 = new User(333l, "mengting", "Mengting", "Yao",List.of(member3));
        user4 = new User(444l, "sami", "Samson", "Desta", List.of(member4));
        user5 = new User(555l, "guest", "Guest", "Guest", List.of(member5));


        paste1 = new Paste(
                "paste111", "int x = 5;", "how to initialize", Language.CPP, (Member) member1,
                LocalDateTime.now().minusYears(1l), LocalDateTime.now());
        paste2 = new Paste(
                "paste222", "System.out.prinln(5)", "print integer", Language.JAVA, (Member) member2,
                LocalDateTime.now().minusYears(2l), LocalDateTime.now());
        paste3 = new Paste(
                "paste333", "string x = 'hi';", "initialize string", Language.CPP, (Member) member3,
                LocalDateTime.now().minusYears(3l), LocalDateTime.now());
        paste4 = new Paste(
                "paste444", "collect.Collector(collect.toList();", "convert to list", Language.JAVA, (Member) member4,
                LocalDateTime.now().minusYears(1l), LocalDateTime.now());
        paste5 = new Paste(
                "paste444", "def (2+5)", "function def", Language.PYTHON, (Member) member4,
                LocalDateTime.now().minusYears(2l), LocalDateTime.now());

        paste1.setRating(10);
        paste2.setRating(5);
        paste3.setRating(20);
        paste4.setRating(15);
        paste5.setRating(30);

        paste1.setNumOfViews(100);
        paste2.setNumOfViews(45);
        paste3.setNumOfViews(230);
        paste4.setNumOfViews(145);
        paste5.setNumOfViews(375);

        ((Member) member1).setPasteList(List.of(paste1));
        ((Member) member2).setPasteList(List.of(paste2));
        ((Member) member3).setPasteList(List.of(paste3));
        ((Member) member4).setPasteList(List.of(paste4));
        ((Member) member5).setPasteList(List.of(paste5));



        feedback1 = new Feedback("edu.miu.Feedback 1", "Thank you", LocalDateTime.now().minusMonths(5),
                paste1, 111l, "abdi");
        feedback2 = new Feedback("edu.miu.Feedback 2", "Nice help", LocalDateTime.now().minusMonths(3),
                paste2, 111l, "abdi");
        feedback3 = new Feedback("edu.miu.Feedback 3", "have problem with the code", LocalDateTime.now().minusMonths(3),
                paste3, 111l, "abdi");
        feedback4 = new Feedback("edu.miu.Feedback 4", "Great", LocalDateTime.now().minusMonths(2),
                paste4, 111l, "abdi");

        feedback5 = new Feedback("edu.miu.Feedback 5", "Great Help", LocalDateTime.now().minusMonths(5),
                paste1, 111l, "abdi");
        feedback6 = new Feedback("edu.miu.Feedback 6", "String need Capital?", LocalDateTime.now().minusMonths(5),
                paste1, 111l, "abdi");
        feedback7 = new Feedback("edu.miu.Feedback 7", "Right this is C++", LocalDateTime.now().minusMonths(5),
                paste2, 111l, "abdi");
        feedback8 = new Feedback("edu.miu.Feedback 8", "Not good", LocalDateTime.now().minusMonths(5),
                paste1, 333l, "mengting");
        feedback9 = new Feedback("edu.miu.Feedback 1", "Thank you", LocalDateTime.now().minusMonths(5),
                paste2, 333l, "mengting");
        feedback10 = new Feedback("edu.miu.Feedback 2", "Nice help", LocalDateTime.now().minusMonths(3),
                paste3, 333l, "mengting");
        feedback11 = new Feedback("edu.miu.Feedback 3", "have problem with the code", LocalDateTime.now().minusMonths(3),
                paste5, 333l, "mengting");
        feedback12 = new Feedback("edu.miu.Feedback 4", "Great", LocalDateTime.now().minusMonths(2),
                paste4, 333l, "abdi");

        feedback13 = new Feedback("edu.miu.Feedback 5", "Great Help", LocalDateTime.now().minusMonths(5),
                paste1, 444l, "sami");
        feedback14 = new Feedback("edu.miu.Feedback 6", "String need Capital?", LocalDateTime.now().minusMonths(5),
                paste1, 444l, "sami");
        feedback15 = new Feedback("edu.miu.Feedback 7", "Right this is C++", LocalDateTime.now().minusMonths(5),
                paste4, 444l, "sami");
        feedback16 = new Feedback("edu.miu.Feedback 8", "Not good", LocalDateTime.now().minusMonths(5),
                paste1, 444l, "sami");

        feedbackListPaste1.addAll(List.of(feedback1, feedback5, feedback6, feedback8, feedback13, feedback14, feedback16));
        feedbackListPaste2.addAll(List.of(feedback2, feedback7, feedback9));
        feedbackListPaste3.addAll(List.of(feedback3, feedback10));
        feedbackListPaste4.addAll(List.of(feedback4, feedback12, feedback15));
        feedbackListPaste5.addAll(List.of(feedback11));

        paste1.setFeedbacks(feedbackListPaste1);
        paste2.setFeedbacks(feedbackListPaste2);
        paste3.setFeedbacks(feedbackListPaste3);
        paste4.setFeedbacks(feedbackListPaste4);
        paste5.setFeedbacks(feedbackListPaste5);

        pasteListMember1.addAll(List.of(paste1));
        pasteListMember2.addAll(List.of(paste2));
        pasteListMember3.addAll(List.of(paste3));
        pasteListMember4.addAll(List.of(paste4, paste5));

        listOfUser.addAll(List.of(user1,user2,user3,user4, user5));

    }

    @Test
   void getPastesWithHighestFeedbackTest() {
        List<Paste> pastes=List.of(paste1,paste2,paste4);
        List<Paste> selectedPaste=UtilPaste.getPastesWithHighestFeedback.apply(listOfUser,3L);
        Assertions.assertEquals(pastes.get(0),selectedPaste.get(0));

    }

    @Test
    void getTopKMostViewedPasteTest() {
        List<Paste> topViewedPaste = UtilPaste.getTopKMostViewedPaste.apply(listOfUser, 3, LocalDate.now().minusYears(2l).getYear());

        Assertions.assertEquals(375, topViewedPaste.get(0).getNumOfViews());
    }

}