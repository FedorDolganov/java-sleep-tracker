package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.Functions.*;

import java.util.*;
import java.util.function.Function;

public class SleepTrackerApp {

    private static LinkedHashMap<Function<LinkedList<SleepDaySession>, Integer>, SleepAnalysisResult> statFunctions;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу с логом сна:");

        String filePath = scanner.nextLine();

        SleepingSession sleepingSession = new SleepingSession(filePath);

        statFunctions = new LinkedHashMap<>();

        statFunctions.put(new GetCountSession(), new SleepAnalysisResult("Кол-во сессий сна: %result%"));
        statFunctions.put(new GetSessionMinimal(), new SleepAnalysisResult("Минимальная продолжительность сессии (мин): %result%"));
        statFunctions.put(new GetSessionMaximal(), new SleepAnalysisResult("Максимальная продолжительность сессии (мин): %result%"));
        statFunctions.put(new GetSessionMean(), new SleepAnalysisResult("Средняя продолжительность сессии (мин): %result%"));
        statFunctions.put(new GetCountBadSession(), new SleepAnalysisResult("Кол-во сессий с плохим качеством сна: %result%"));
        statFunctions.put(new GetSessionSleepless(), new SleepAnalysisResult("Кол-во бессоных ночей: %result%"));

        for (Function<LinkedList<SleepDaySession>, Integer> function : statFunctions.keySet()) {
            System.out.println(statFunctions.get(function).getFormattedMessage(function.apply(sleepingSession.getDaySessions())));
        }

        GetUserType userType = new GetUserType();
        SleepAnalysisResult userTypeFormatter = new SleepAnalysisResult("Тип пользователя: %result%");

        System.out.println(userTypeFormatter.getFormattedMessage(userType.apply(sleepingSession.getDaySessions())));
    }
}