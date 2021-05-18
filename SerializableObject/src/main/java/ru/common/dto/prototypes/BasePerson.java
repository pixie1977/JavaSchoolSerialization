package ru.common.dto.prototypes;

import java.io.Serializable;

public class BasePerson implements Serializable{
    private final String name;

    public BasePerson(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "{BasePerson[name=\""+name+"\"]}";
    }
}
