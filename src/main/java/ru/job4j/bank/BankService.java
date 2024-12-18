package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
                break;
            }
        }
    }

    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport))
                && !users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (users.containsKey(findByPassport(passport))) {
            for (Account account : users.get(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        if (users.get(findByPassport(sourcePassport)).contains(findByRequisite(sourcePassport, sourceRequisite))
                && users.get(findByPassport(destinationPassport)).contains(findByRequisite(destinationPassport, destinationRequisite))
                && findByRequisite(sourcePassport, sourceRequisite).getBalance() >= amount
        ) {
            Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
            accountSource.setBalance(accountSource.getBalance() - amount);
            Account accountDestination = findByRequisite(destinationPassport, destinationRequisite);
            accountDestination.setBalance(accountDestination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}