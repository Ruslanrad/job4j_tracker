package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает Аккаунт закрепленный за Пользователем в банке
 * @author Залилов Руслан
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод hashCode переопределён для правильной работы тестов
     * @return числовое значение hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}