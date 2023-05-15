package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        passwordCheck("user_1", "aaa", "aaa1");
    }
    //regex pattern. Латинские буквы, цифры и знак подчеркивания
    static String pattern = "[A-Za-z0-9]*_?[A-Za-z0-9]*";

    //Валидация логина и пароля
    public static boolean passwordCheck(String login, String password, String confirmPassword) {
        Pattern checkPattern = Pattern.compile(pattern);
        Matcher loginMatcher = checkPattern.matcher(login);
        Matcher passwordMatcher = checkPattern.matcher(password);

        try {
            if (login.length() > 19) {
                throw new WrongLoginException("Введенный логин слишком длинный");
            }
            if (!loginMatcher.matches()) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
            if (!passwordMatcher.matches()) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
            if (password.length() > 19) {
                throw new WrongPasswordException("Введенный пароль слишком длинный");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }

        } catch (WrongPasswordException e) {
            System.out.println("Ошибка пароля: " + e.getMessage());
            return false;
        } catch (WrongLoginException e) {
            System.out.println("Ошибка логина: " + e.getMessage());
            return false;
        }
        return true;
    }
}