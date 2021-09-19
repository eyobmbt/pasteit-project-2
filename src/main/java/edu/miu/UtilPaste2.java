package edu.miu;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface UtilPaste2 {


    BiFunction<List<User>, Long, List<Paste>> getPastesWithHighestFeedback =
            (user, kOfPastes) -> user.stream()
                    .flatMap(u -> u.getRoles().stream())
                    .filter(role -> role instanceof Member)
                    .map(role -> (Member) role)
                    .flatMap(member -> member.getPasteList().stream())
                    .flatMap(fed -> fed.getFeedbacks().stream())
                    .collect(Collectors.groupingBy(Feedback::getPaste, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1, e2) -> (e2.getValue().intValue() - e1.getValue().intValue()))
                    .limit(kOfPastes)
                    .map(pastes -> pastes.getKey())
                    .collect(Collectors.toList());
    // Comparator.comparing(Map.Entry::getValue)

    TriFunction<List<User>, Integer, Integer, List<Language>> listTopUsedLanguagesPerYear =
            (user, kOfLanguages, year) -> user.stream()
                    .flatMap(us->us.getRoles().stream())
                    .filter(role -> role instanceof Member)
                    .map(role -> (Member) role)
                    .flatMap(paste -> paste.getPasteList().stream())
                    .filter(paste -> paste.getPasteDateTime().getYear() == year)
                    .collect(Collectors.groupingBy(Paste::getLanguage, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1, e2) -> (e2.getValue().intValue() - e1.getValue().intValue()))
                    .sorted((e1, e2) -> (e2.getKey().compareTo(e1.getKey())))
                    .limit(kOfLanguages)
                    .map(lang -> lang.getKey())
                    .collect(Collectors.toList());

    TriFunction<User,Integer,Integer,List<Paste>>  getHighestPastesBySizeUsernameOngivenYear=
            (user,kOfPastes,year)-> Stream.of(user)
                    .flatMap(ur->ur.getRoles().stream())
                    .filter(user1->user1 instanceof Member)
                    .map(user2->(Member) user2)
                    .flatMap(meb->meb.getPasteList().stream())
                    .filter(paste->paste.getPasteDateTime().getYear()==year)
                    .sorted((paste1,paste2)->paste2.getContent().length()-paste1.getContent().length())
                    .limit(kOfPastes)
                    .collect(Collectors.toList());
    TriFunction<List<User>,Integer,Integer,List<Member>> getTopKMembersWithMostPastesOnaGivenYear=
            (users,k,year)->users.stream()
                    .flatMap(usrs->usrs.getRoles().stream())
                    .filter(role->role instanceof Member)
                    .map(meb->(Member) meb)
                    .flatMap(member -> member.getPasteList().stream())
                    .filter(pasts->pasts.getPasteDateTime().getYear()==year)
                    .collect(Collectors.groupingBy(Paste::getMember,Collectors.counting()))
                    .entrySet().stream()
                    .sorted((p1,p2)->p2.getValue().intValue()-p1.getValue().intValue())
                    .map(lspaste->lspaste.getKey())
                    .limit(k)
                    .collect(Collectors.toList());


}
