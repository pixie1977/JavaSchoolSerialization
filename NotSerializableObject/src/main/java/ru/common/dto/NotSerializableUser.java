package ru.common.dto;

public class NotSerializableUser {
    private final String name;
    private final String lastName;


    public NotSerializableUser(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return "{NotSerializableUser[name=\""+name+"\" lastName=\""+lastName+"\"]}";
    }
}
