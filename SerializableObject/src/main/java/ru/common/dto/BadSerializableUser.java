package ru.common.dto;

import ru.common.dto.prototypes.FullPerson;

import java.io.Serializable;

public class BadSerializableUser extends FullPerson implements Serializable{
    public BadSerializableUser(String name, String lastName) {
        super(name, lastName);
    }

    public String toString(){
        return "{BadSerializableUser[name=\""+getName()+"\"" + " lastname=\""+getLastName()+"\"]}";
    }
}
