package ru.common.dto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GoodSerializableUser implements Serializable {
    private final String name;
    private final String lastName;


    public GoodSerializableUser(String name, String lastName) {
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
        return "{GoodSerializableUser[name=\""+name+"\" lastName=\""+lastName+"\"]}";
    }
}
