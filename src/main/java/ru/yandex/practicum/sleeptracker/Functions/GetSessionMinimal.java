package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.function.Function;

public class GetSessionMinimal implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        OptionalInt min = sleepDaySessions.stream()
                .mapToInt(session -> (int) session.getDuration().toMinutes())
                .min();

        return min.getAsInt();
    }

}
