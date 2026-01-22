package ru.yandex.practicum.sleeptracker;

public class SleepAnalysisResult {

    private String format;

    public SleepAnalysisResult(String format) {
        this.format = format;
    }

    public String getFormattedMessage(int result) {
        return format.replace("%result%", String.valueOf(result));
    }

    public String getFormattedMessage(UserType result) {
        return format.replace("%result%", result.getName());
    }
}
