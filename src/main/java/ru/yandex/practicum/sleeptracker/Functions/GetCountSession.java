package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.util.LinkedList;
import java.util.function.Function;

public class GetCountSession implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        return sleepDaySessions.size();
    }

}
