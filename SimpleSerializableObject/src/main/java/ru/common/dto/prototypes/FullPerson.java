package ru.common.dto.prototypes;

import java.io.Serializable;

public class FullPerson extends BasePerson implements Serializable{
    private final String lastName;

    public FullPerson(String name, String lastName) {
        super(name);
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return "{FullPerson[name=\""+getName()+"\"" + " lastname="+lastName+"]}";
    }
}
