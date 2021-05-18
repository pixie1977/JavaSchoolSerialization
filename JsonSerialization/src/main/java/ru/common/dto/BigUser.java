package ru.common.dto;

public class BigUser extends User {
    private Integer age = 0;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "{BigUser[name=\"" + getName() + "\" lastName=\""
                + getLastName() + "\" age=\"" + age + "\"]}";
    }
}
