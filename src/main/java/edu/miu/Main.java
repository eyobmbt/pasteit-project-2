package edu.miu;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;

import static edu.miu.UtilPaste.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        do {
            information();
            System.out.println("Input No: ");
             num= in.nextInt();
            listOfFunctions(num);
        }while (num != 0);
    }



    public static void information(){
        System.out.println("Press your Choices Number and Press Enter");
        System.out.println("=================================================\n");
        System.out.println("0: To Exit");
        System.out.println("1: Get Top K Members With Most Pastes On a Given Year");
        System.out.println("2: List Top Used Languages on a given Year");
        System.out.println("3: List Highest Pastes by Size for a given Username and on given Year");
        System.out.println("4: List All Pastes With Highest Feedback");
        System.out.println("5: Get Top K Most Viewed Paste");
        System.out.println("6: List K Worst Rated Pastes");
        System.out.println("7: List Top K Reward With Rate And Number of Viewed Pastes");
        System.out.println("8: List Of K Top Feedbacks Pastes In A Given Year");
        System.out.println("9: List Active Users Per Year");
        System.out.println("10: Month With The Highest Paste in A Given Year");
        System.out.println("11: list K Total Expired Pastes By Given Year");
        System.out.println("12: Find the total Feedbacks in a Give Year");
    }
    public static void listOfFunctions(int num) {
        DataFactory data = new DataFactory();
        Scanner in = new Scanner(System.in);
        switch (num) {
            case 1:
                System.out.println("Enter the year:");
                int year = in.nextInt();
                System.out.println("Enter K: ");
                int k = in.nextInt();
                List<Member> members = UtilPaste.getTopKMembersWithMostPastesOnaGivenYear.apply(data.listOfUser, k, year);
                for (Member b : members) {
                    System.out.println(b);
                }
                break;
            case 2:

                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Language> topLanguage = listTopUsedLanguagesPerYear.apply(data.listOfUser, k, year);
                for (Language l : topLanguage) {
                    int i=1;
                    System.out.print(i+". ");
                    System.out.println(l);i++;
                }
                break;
            case 3:

                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> highestPaste = getHighestPastesBySizeUsernameOngivenYear.apply(data.user4, k, year);
                for (Paste paste:highestPaste) {
                    System.out.println(paste);
                }
                break;
            case 4:
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> pastes=getPastesWithHighestFeedback.apply(data.listOfMemberUsers,(long)k);
                for (Paste paste:pastes) {
                    System.out.println(paste);
                }

                break;
            case 5:
                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> pastes1 = getTopKMostViewedPaste.apply(data.listOfUser, k, year);
                for (Paste paste:pastes1) {
                    System.out.println(paste);
                }
                break;
            case 6:
                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> pastes2 = getTopKWorstRatedPaste.apply(data.listOfUser, k, year);
                for (Paste paste:pastes2) {
                    System.out.println(paste);
                }
                break;
            case 7:
                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> pastes3 = getTopKRewardWithRateAndNumberOfViewedPaste.apply(data.listOfUser, k, year);
                for (Paste paste:pastes3) {
                    System.out.println(paste);
                }
                break;
            case 8:
                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> pastes4 = listOfKTopFeedbackPastesInAGivenYear.apply(data.administrator, k, (long)year);
                for (Paste paste:pastes4) {
                    System.out.println(paste);
                }
                break;
            case 9:
                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Member> members1=listActiveUserPerYear.apply(data.administrator, k, year);
                for (Member b : members1) {
                    System.out.println(b);
                }
                break;
            case 10:
                System.out.println("Enter the year:");
                year = in.nextInt();
               Optional< Month > month=aMonthWithTheHighestPasteInAGivenYear.apply(data.listOfMemberUsers,year);
                month.ifPresent(System.out::println);
                break;
            case 11:
                System.out.println("Enter the year:");
                year = in.nextInt();
                System.out.println("Enter K: ");
                k = in.nextInt();
                List<Paste> pasteList= listKTotalExpiredPastesByGivenYear.apply(data.listOfMemberUsers,year,k);
                for (Paste paste:pasteList) {
                    System.out.println(paste);
                }
                break;
            case 12:
                List<Paste> listOfPaste = List.of(data.paste1, data.paste2, data.paste4);
                System.out.println("Enter the commenter Id:");
                long commnter= (long) in.nextInt();
                System.out.println("Enter the year:");
                year= in.nextInt();
                long total=TotalFeedbacksInGivenYearForAlistofPasts.apply(listOfPaste,commnter,(long)year);
                System.out.println("Total Feedbacks given by user: "+total);
                break;
            case 0:
                break;
            default :
                System.out.println("Please Enter no 1 to 12 or  0 to exit");
                num = in.nextInt();

        }
    }
    }

