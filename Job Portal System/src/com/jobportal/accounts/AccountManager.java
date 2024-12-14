package com.jobportal.accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static Map<String, User> users = new HashMap<>();

    public static void signUp(User user) {
        if (users.containsKey(user.getEmail())) {
            System.out.println("\nThis email already exists. Please use a different email.");
            return;
        }
        users.put(user.getEmail(), user);
        System.out.println("\nSign-up successful! Welcome, " + user.getName() + "!");
    }

    public static User login(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
