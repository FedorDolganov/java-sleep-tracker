package ru.yandex.practicum.sleeptracker.Functions;

import ru.yandex.practicum.sleeptracker.SleepDaySession;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

public class GetSessionSleepless implements Function<LinkedList<SleepDaySession>, Integer> {

    @Override
    public Integer apply(LinkedList<SleepDaySession> sleepDaySessions) {
        LocalDateTime startSess = sleepDaySessions.getFirst().getStartSession();
        LocalDateTime endSess = sleepDaySessions.getLast().getEndSession();

        if (startSess.getHour() >= 12) {
            startSess = startSess.plusDays(1);
        } else {
            startSess = startSess.minusDays(1);
        }

        long nightsCount = Period.between(startSess.toLocalDate(), endSess.toLocalDate()).getDays() + 1;

        long countSleeplessTime = LongStream.range(0, nightsCount)
            .mapToObj(startSess::plusDays)
            .filter(nightDate -> isSleeplessNight(nightDate.toLocalDate(), sleepDaySessions))
            .count();

        return (int) countSleeplessTime;
    }

    private boolean isSleeplessNight(LocalDate nightDate, List<SleepDaySession> sessions) {
        LocalDateTime nightStart = nightDate.atTime(0, 0);
        LocalDateTime nightEnd = nightDate.atTime(6, 0);

        return sessions.stream().noneMatch(session -> {
            LocalDateTime sessionStart = session.getStartSession();
            LocalDateTime sessionEnd = session.getEndSession();

            return !sessionEnd.isBefore(nightStart) && !sessionStart.isAfter(nightEnd);
        });
    }

}
