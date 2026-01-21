package ru.yandex.practicum.sleeptracker;

public enum UserType {

    OWL("Сова"),
    LARK("Жаворонок"),
    PIGEON("Голубь");

    private String name;

    UserType(String text) {
        this.name = text;
    }

    public String getName(){
        return this.name;
    }

}
