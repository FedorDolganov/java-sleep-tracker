package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;
import ru.yandex.practicum.sleeptracker.SleepDaySessionType;

import java.util.LinkedList;
import java.util.function.Function;

public class GetCountBadSession implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        return (int) sleepDaySessions.stream()
                .filter(session -> session.getSessionType().equals(SleepDaySessionType.BAD))
                .count();
    }

}
