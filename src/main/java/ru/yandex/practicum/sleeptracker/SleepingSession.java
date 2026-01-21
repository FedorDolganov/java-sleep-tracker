package ru.yandex.practicum.sleeptracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class SleepingSession {

    private final File logFile;
    private LinkedList<SleepDaySession> daySessions;
    private final DateTimeFormatter dateTimeFormatter;

    public SleepingSession(String filePath) {
        this.logFile = new File(filePath);
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        this.daySessions = new LinkedList<>();

        generateDaySession();
    }

    private void generateDaySession() {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            while (reader.ready()) {
                String[] sessionData = reader.readLine().split(";");

                LocalDateTime startSession = LocalDateTime.parse(sessionData[0], dateTimeFormatter);

                LocalDateTime endSession = LocalDateTime.parse(sessionData[1], dateTimeFormatter);

                SleepDaySessionType type = null;

                switch (sessionData[2]) {
                    case "GOOD":
                        type = SleepDaySessionType.GOOD;
                        break;
                    case "NORMAL":
                        type = SleepDaySessionType.NORMAL;
                        break;
                    case "BAD":
                        type = SleepDaySessionType.BAD;
                        break;
                }

                daySessions.add(new SleepDaySession(startSession, endSession, type));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public LinkedList<SleepDaySession> getDaySessions() {
        return daySessions;
    }

}
