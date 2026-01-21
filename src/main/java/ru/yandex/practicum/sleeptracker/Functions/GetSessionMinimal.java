package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;

public class GetSessionMinimal implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        ArrayList<Duration> durations = getSleepDayDurations(sleepDaySessions);

        int minSleepTime = (int) durations.getFirst().toMinutes();

        for (Duration duration : durations) {
            if (duration.toMinutes() < minSleepTime) {
                minSleepTime = (int) duration.toMinutes();
            }
        }

        return minSleepTime;
    }

    private ArrayList<Duration> getSleepDayDurations(LinkedList<SleepDaySession> daySessions) {
        ArrayList<Duration> durations = new ArrayList<>();

        for (SleepDaySession sleepDaySession : daySessions) {
            durations.add(sleepDaySession.getDuration());
        }

        return durations;
    }

}
