package org.example;

import org.apache.commons.validator.routines.EmailValidator;


public class User {
    private String login;
    private String email;

    public User(String login, String email) {
        if (login.equals(email)) {
            throw new IdentificationException("Логин и пароль совпадают!");
        } else {
            setLogin(login);
            setEmail(email);
        }
    }

    public User() {
        if (getLogin() == null || getEmail() == null) {
            throw new IdentificationException("Пароль или логин не введен!");
        }
    }

    private void setEmail(String email) {
        if (EmailValidator.getInstance().isValid(email)) {
            this.email = email;
        } else {
            throw new IdentificationException("Некорректный адрес почты!");
        }
    }

    private void setLogin(String login) {
        if (!login.isBlank()) {
            this.login = login;
        } else {
            throw new IdentificationException("Некорректный логин!");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
