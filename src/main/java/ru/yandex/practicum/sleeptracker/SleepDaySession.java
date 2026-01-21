package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.time.LocalDateTime;

public class SleepDaySession {

    private final LocalDateTime startSession;
    private final LocalDateTime endSession;
    private final SleepDaySessionType sessionType;

    public SleepDaySession(LocalDateTime startSession, LocalDateTime endSession, SleepDaySessionType sessionType) {
        this.startSession = startSession;
        this.endSession = endSession;
        this.sessionType = sessionType;
    }

    public Duration getDuration() {
        return Duration.between(startSession, endSession);
    }

    public SleepDaySessionType getSessionType() {
        return sessionType;
    }

    public LocalDateTime getStartSession() {
        return startSession;
    }

    public LocalDateTime getEndSession() {
        return endSession;
    }
}
