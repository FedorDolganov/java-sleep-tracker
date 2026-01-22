package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.function.Function;

public class GetSessionMaximal implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        OptionalInt max = sleepDaySessions.stream()
                .mapToInt(session -> (int) session.getDuration().toMinutes())
                .max();

        return max.getAsInt();
    }

}
