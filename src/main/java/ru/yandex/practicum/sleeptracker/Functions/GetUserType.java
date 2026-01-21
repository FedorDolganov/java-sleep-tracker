package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;
import ru.yandex.practicum.sleeptracker.UserType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetUserType implements Function<LinkedList<SleepDaySession>, UserType> {

    @Override
    public UserType apply(LinkedList<SleepDaySession> sleepDaySessions) {
        UserType userType = null;

        List<SleepDaySession> nightSessions = sleepDaySessions.stream()
                .filter(this::isNightSleep)
                .toList();

        if (nightSessions.isEmpty()) {
            userType = UserType.PIGEON;
        }

        HashMap<UserType, Long> typeCounts = (HashMap<UserType, Long>) nightSessions.stream()
                .collect(Collectors.groupingBy(
                        this::getType,
                        Collectors.counting()
                ));

        long owlCount = typeCounts.getOrDefault(UserType.OWL, 0L);
        long larkCount = typeCounts.getOrDefault(UserType.LARK, 0L);
        long pigeonCount = typeCounts.getOrDefault(UserType.PIGEON, 0L);

        if (owlCount > larkCount && owlCount > pigeonCount) {
            userType = UserType.OWL;
        } else if (larkCount > owlCount && larkCount > pigeonCount) {
            userType = UserType.LARK;
        } else {
            userType = UserType.PIGEON;
        }

        return userType;
    }

    private boolean isNightSleep(SleepDaySession session) {
        int startHour = session.getStartSession().getHour();
        return startHour >= 18 || startHour <= 6;
    }

    private UserType getType(SleepDaySession session) {
        int sleepHour = session.getStartSession().getHour();
        int wakeHour = session.getEndSession().getHour();

        if (sleepHour >= 23 && wakeHour >= 9) {
            return UserType.OWL;
        } else if (sleepHour < 22 && wakeHour < 7) {
            return UserType.LARK;
        } else {
            return UserType.PIGEON;
        }
    }

}
