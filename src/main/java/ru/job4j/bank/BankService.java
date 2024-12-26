package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает взаимодествие банка с пользователем
 * @author Залилов Руслан
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает данные пользователся,
     * проверяет существует ли данный пользователь в базе,
     * если данного пользователя не существует, то добавляет пользователя в базу
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает паспортные данные пользователя и удаляет пользователя, если он есть в базе
     * @param passport
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает паспортные данные пользователя и его аккаунт,
     * если пользователь существует и у него нет аккаунта, то ему создают новый аккаунт в базе.
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод принимает паспортные данные для поиска пользователя в базе
     * @param passport
     * @return null or user
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает паспортные данные и реквизиты для поиска пользователя и его аккаунта в базе
     * @param passport
     * @param requisite
     * @return null or account
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает паспортные данные (номер паспорта, реквизиты)
     * пользователя отправителя  и пользователя получателя, а также сумма для пересылки денег.
     * Если данные пользователи существуют и на счёте отправителя достаточно денег,
     * то сумма со счета отправителя снимается,
     * счет получателя пополняется на данную сумму.
     * @param sourcePassport
     * @param sourceRequisite
     * @param destinationPassport
     * @param destinationRequisite
     * @param amount
     * @return true or faulce
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account accountDestination = findByRequisite(destinationPassport, destinationRequisite);
        if (accountSource != null
                && accountDestination != null
                && accountSource.getBalance() >= amount) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDestination.setBalance(accountDestination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Данный метод нужен для тестов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}