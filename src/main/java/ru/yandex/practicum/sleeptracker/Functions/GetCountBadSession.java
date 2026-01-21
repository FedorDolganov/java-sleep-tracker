package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;
import ru.yandex.practicum.sleeptracker.SleepDaySessionType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;

public class GetCountBadSession implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        int countBadSleep = 0;

        for (SleepDaySessionType type : getSleepDayTypes(sleepDaySessions)) {
            if (type.equals(SleepDaySessionType.BAD)) {
                countBadSleep++;
            }
        }

        return countBadSleep;
    }

    private ArrayList<SleepDaySessionType> getSleepDayTypes(LinkedList<SleepDaySession> daySessions) {
        ArrayList<SleepDaySessionType> durations = new ArrayList<>();

        for (SleepDaySession sleepDaySession : daySessions) {
            durations.add(sleepDaySession.getSessionType());
        }

        return durations;
    }

}
