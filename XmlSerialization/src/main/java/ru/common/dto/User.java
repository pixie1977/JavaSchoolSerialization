package ru.common.dto;

public class User { //Serializable не обязателен
    private String name;
    private String lastName;

    // пустой конструктор обязателен
    public User() {
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    // геттеры и сеттеры обязательны
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "{User[name=\"" + name + "\" lastName=\"" + lastName + "\"]}";
    }
}
