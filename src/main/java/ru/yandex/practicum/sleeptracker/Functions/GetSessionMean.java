package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;

public class GetSessionMean implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        ArrayList<Duration> durations = getSleepDayDurations(sleepDaySessions);

        int sumSleepTime = 0;

        for (Duration duration : durations) {
            sumSleepTime += (int) duration.toMinutes();
        }

        return sumSleepTime / durations.size();
    }

    private ArrayList<Duration> getSleepDayDurations(LinkedList<SleepDaySession> daySessions) {
        ArrayList<Duration> durations = new ArrayList<>();

        for (SleepDaySession sleepDaySession : daySessions) {
            durations.add(sleepDaySession.getDuration());
        }

        return durations;
    }

}
