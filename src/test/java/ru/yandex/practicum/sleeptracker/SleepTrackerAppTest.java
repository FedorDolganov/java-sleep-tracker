package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.Functions.*;

import java.util.Scanner;

public class SleepTrackerAppTest {

    static SleepingSession sleepingSessionN1, sleepingSessionN2, sleepingSessionN3, sleepingSessionN4;

    @BeforeAll
    public static void loadTestSession() {
        sleepingSessionN1 = new SleepingSession("src/main/resources/test_sleep_log_n1.txt");
        sleepingSessionN2 = new SleepingSession("src/main/resources/test_sleep_log_n2.txt");
        sleepingSessionN3 = new SleepingSession("src/main/resources/test_sleep_log_n3.txt");
        sleepingSessionN4 = new SleepingSession("src/main/resources/test_sleep_log_n4.txt");
    }


    @Test
    public void testCountOfAllSessions7() {
        GetCountSession session = new GetCountSession();

        Assertions.assertEquals(7, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testCountOfAllSessions13() {
        GetCountSession session = new GetCountSession();

        Assertions.assertEquals(13, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testMinimalSession20() {
        GetSessionMinimal session = new GetSessionMinimal();

        Assertions.assertEquals(20, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testMinimalSession45() {
        GetSessionMinimal session = new GetSessionMinimal();

        Assertions.assertEquals(45, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testMaximalSession620() {
        GetSessionMaximal session = new GetSessionMaximal();

        Assertions.assertEquals(620, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testMaximalSession500() {
        GetSessionMaximal session = new GetSessionMaximal();

        Assertions.assertEquals(500, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testMeanSession382() {
        GetSessionMean session = new GetSessionMean();

        Assertions.assertEquals(382, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testMeanSession345() {
        GetSessionMean session = new GetSessionMean();

        Assertions.assertEquals(345, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testCountBadSessions1() {
        GetCountBadSession session = new GetCountBadSession();

        Assertions.assertEquals(1, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testCountBadSessions2() {
        GetCountBadSession session = new GetCountBadSession();

        Assertions.assertEquals(2, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testCountSleepness15() {
        GetSessionSleepless session = new GetSessionSleepless();

        Assertions.assertEquals(15, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testCountSleepness20() {
        GetSessionSleepless session = new GetSessionSleepless();

        Assertions.assertEquals(20, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testCountSleepness24() {
        GetSessionSleepless session = new GetSessionSleepless();

        Assertions.assertEquals(24, session.apply(sleepingSessionN3.getDaySessions()));
    }

    @Test
    public void testCountSleepness21() {
        GetSessionSleepless session = new GetSessionSleepless();

        Assertions.assertEquals(21, session.apply(sleepingSessionN4.getDaySessions()));
    }

    @Test
    public void testUserTypeOwl() {
        GetUserType session = new GetUserType();

        Assertions.assertEquals(UserType.OWL, session.apply(sleepingSessionN1.getDaySessions()));
    }

    @Test
    public void testUserTypePigeon() {
        GetUserType session = new GetUserType();

        Assertions.assertEquals(UserType.PIGEON, session.apply(sleepingSessionN2.getDaySessions()));
    }

    @Test
    public void testUserTypeLark() {
        GetUserType session = new GetUserType();

        Assertions.assertEquals(UserType.LARK, session.apply(sleepingSessionN3.getDaySessions()));
    }

}