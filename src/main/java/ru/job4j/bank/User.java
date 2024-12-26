package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс User описывает пользователя банка и его данные(паспорт, имя)
 * @author Залилов Руслан
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод equils переопределён для правильной работы тестов
     * @return true or faulce
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод hashCode переопределён для правильной работы тестов
     * @return числовое значение hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}