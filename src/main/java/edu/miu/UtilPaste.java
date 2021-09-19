package edu.miu;

import javax.swing.text.html.Option;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface UtilPaste {

    //Eyob
    //START
    BiFunction<List<User>,Long, List<Paste>> getPastesWithHighestFeedback=
            (user,kOfPastes)->user.stream()
                    .flatMap(u->u.getRoles().stream())
                    .filter(role->role instanceof Member)
                    .map(role->(Member) role )
                    .flatMap(member->member.getPasteList().stream())
                    .flatMap(fed->fed.getFeedbacks().stream())
                    .collect(Collectors.groupingBy(Feedback::getPaste,Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1,e2)->(e2.getValue().intValue()-e1.getValue().intValue()))
                    .limit(kOfPastes)
                    .map(pastes->pastes.getKey())
                    .collect(Collectors.toList());
   // Comparator.comparing(Map.Entry::getValue)

TriFunction<List<User>,Integer,Integer,List<Language>> listTopUsedLanguagesPerYear=
        (user,kOfLanguages,year)->Stream.of(user)
                .filter(role->role instanceof Member)
                .map(role->(Member) role)
                .flatMap(paste->paste.getPasteList().stream())
                .filter(paste->paste.getPasteDateTime().getYear()==year)
                .collect(Collectors.groupingBy(Paste::getLanguage,Collectors.counting()))
                .entrySet().stream()
                .sorted((e1,e2)->(e2.getValue().intValue()-e1.getValue().intValue()))
                .map(lang->lang.getKey())
                .limit(kOfLanguages)
                .collect(Collectors.toList());
//Comparator.comparing(Map.Entry::getValue)


    //END

    // SAMI
    // START
    Predicate<Role> isMember = r -> r instanceof Member;

    Function<Paste, Integer> getNumberOfPastViews = paste ->
            paste.getNumOfViews();

    TriFunction<List<User>, Integer, Integer, List<Paste>> getTopKMostViewedPaste = (user, k, year) ->
            user.stream()
                    .flatMap(u -> u.getRoles().stream())
                    .filter(u -> isMember.test(u))
                    .map(u -> (Member) u)
                    .flatMap(u -> u.getPasteList().stream())
                    .filter(p -> p.getPasteDateTime().getYear() == year)
                    .sorted(Comparator.comparingInt(Paste::getNumOfViews).reversed())
                    .limit(k)
                    .collect(Collectors.toList());


    // END


    //ABDI
    //Start

    Function<User, List<Member>> userToMember =
            (user) -> Stream.of(user)
                    .filter(role->role.getRoles() instanceof Member)
                    .map(role->(Member) role.getRoles()).collect(Collectors.toList());

    Function<List<User>, List<Member>> usersToMembers =
            (users) -> users.stream()
                    .flatMap(u -> u.getRoles().stream())
                    .filter(u -> isMember.test(u))
                    .map(u -> (Member) u)
                    .collect(Collectors.toList());


    Function<Administrator, List<User>> administratorToUsers =
            (administrator) -> administrator.getUsers().stream()
                    .collect(Collectors.toList());


    TriFunction<Administrator,Integer,Long, List<Paste>> listOfKTopRatedPastesInAGivenYear =
            (admin, k, year) -> usersToMembers.apply(administratorToUsers.apply(admin)).stream()
                    .flatMap(paste -> paste.getPasteList().stream())
                    .filter(paste -> paste.getPasteDateTime().getYear() == year )
                    .flatMap(paste -> paste.getFeedbacks().stream())
                    .collect(Collectors.groupingBy(Feedback::getPaste))
                    .entrySet().stream()
                    .map(listEntry -> new Tuple<Paste, Long>(listEntry.getKey(), listEntry.getValue().stream().count()))
                    .sorted((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue())
                    .limit(k)
                    .map(memberLongTuple -> memberLongTuple.getKey())
                    .collect(Collectors.toList());

    TriFunction<Administrator, Integer, Integer, List<Member>> listActiveUserPerYear =
            (admin, kOfUser, year) ->
                    Optional.ofNullable(usersToMembers.apply(administratorToUsers.apply(admin)).stream()
                    .flatMap(paste -> paste.getPasteList().stream())
                    .filter(paste -> paste.getPasteDateTime().getYear() == year )
                    .collect(Collectors.groupingBy(paste -> paste.getMemberId()))
                    .entrySet().stream()
                    .map(listEntry -> new Tuple<Member, Long>(listEntry.getKey(), listEntry.getValue().stream().count()))
                    .sorted((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue())
                    .limit(kOfUser)
                    .map(memberLongTuple -> memberLongTuple.getKey())
                    .collect(Collectors.toList())).orElse(null);

    BiFunction<User, Integer, Optional<Month>> aMonthWithTheHighestPastInAGivenYear =
            (user, year)-> userToMember.apply(user).stream()
                    .flatMap(paste -> paste.getPasteList().stream())
                    .filter(paste -> paste.getPasteDateTime().getYear() == year )
                    .collect(Collectors.groupingBy(paste -> paste.getPasteDateTime().getMonth()))
                    .entrySet().stream()
                    .map(listEntry -> new Tuple<Month, Long>(listEntry.getKey(), listEntry.getValue().stream().count()))
                    .sorted((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue())
                    .limit(1)
                    .map(memberLongTuple -> memberLongTuple.getKey())
                    .findFirst();

    //End


}
