package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.Functions.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SleepTrackerApp {

    private static LinkedHashMap<Function<LinkedList<SleepDaySession>, Integer>, SleepAnalysisResult> statFunctions;
    private static List<String> formatedMessages;

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Укажите путь к файлу с логом сна в аргументах запуска.");
            return;
        }

        String filePath = args[0];

        SleepingSession sleepingSession = new SleepingSession(filePath);

        statFunctions = new LinkedHashMap<>();
        formatedMessages = new ArrayList<>();

        statFunctions.put(new GetCountSession(), new SleepAnalysisResult("Кол-во сессий сна: %result%"));
        statFunctions.put(new GetSessionMinimal(), new SleepAnalysisResult("Минимальная продолжительность сессии (мин): %result%"));
        statFunctions.put(new GetSessionMaximal(), new SleepAnalysisResult("Максимальная продолжительность сессии (мин): %result%"));
        statFunctions.put(new GetSessionMean(), new SleepAnalysisResult("Средняя продолжительность сессии (мин): %result%"));
        statFunctions.put(new GetCountBadSession(), new SleepAnalysisResult("Кол-во сессий с плохим качеством сна: %result%"));
        statFunctions.put(new GetSessionSleepless(), new SleepAnalysisResult("Кол-во бессоных ночей: %result%"));

        formatedMessages = statFunctions.keySet().stream()
                .map(function -> statFunctions.get(function).getFormattedMessage(function.apply(sleepingSession.getDaySessions())))
                .peek(System.out::println)
                .collect(Collectors.toList());

        GetUserType userType = new GetUserType();
        SleepAnalysisResult userTypeFormatter = new SleepAnalysisResult("Тип пользователя: %result%");

        System.out.println(userTypeFormatter.getFormattedMessage(userType.apply(sleepingSession.getDaySessions())));
    }
}