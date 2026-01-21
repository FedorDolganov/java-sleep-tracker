package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;

public class GetSessionMaximal implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        int maxSleepTime = 0;

        for (Duration duration : getSleepDayDurations(sleepDaySessions)) {
            if (duration.toMinutes() > maxSleepTime) {
                maxSleepTime = (int) duration.toMinutes();
            }
        }

        return maxSleepTime;
    }

    private ArrayList<Duration> getSleepDayDurations(LinkedList<SleepDaySession> daySessions) {
        ArrayList<Duration> durations = new ArrayList<>();

        for (SleepDaySession sleepDaySession : daySessions) {
            durations.add(sleepDaySession.getDuration());
        }

        return durations;
    }

}
