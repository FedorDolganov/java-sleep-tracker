package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.util.LinkedList;
import java.util.function.Function;

public class GetSessionMean implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        int sum = sleepDaySessions.stream()
                .mapToInt(session -> (int) session.getDuration().toMinutes())
                .sum();

        return sum / sleepDaySessions.size();
    }

}
