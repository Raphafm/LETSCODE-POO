package org.example.model;

import java.util.Scanner;

public abstract class User implements Comparable<User> {
    protected String name;
    protected final String login;
    protected final String password;
    protected final String id;
    protected static final String AGENCY = "0000-1";

    public User(String name, String login, String password, String id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public static String getAGENCY() {
        return AGENCY;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public boolean loginValidate(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "nome: " + name +
                ", identificador: " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return this.id.equals(((User) obj).id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public int compareTo(User user) {
        return this.getName().compareTo(user.getName());
    }

    public abstract void accessMenu(Scanner sc);

}
