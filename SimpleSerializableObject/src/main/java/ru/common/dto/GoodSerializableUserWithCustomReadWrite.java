package ru.common.dto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GoodSerializableUserWithCustomReadWrite implements Serializable {
    private final String name;
    private final String lastName;


    public GoodSerializableUserWithCustomReadWrite(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Using CUSTOM writeObject");
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        System.out.println("Using CUSTOM readObject");
    }

    public String toString(){
        return "{GoodSerializableUser[name=\""+name+"\" lastName=\""+lastName+"\"]}";
    }
}
