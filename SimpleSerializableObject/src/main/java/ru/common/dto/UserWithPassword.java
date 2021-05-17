package ru.common.dto;

public class UserWithPassword extends GoodSerializableUser {
    private final transient String password;

    public UserWithPassword(String name, String lastName, String password) {
        super(name,lastName);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String toString(){
        return "{UserWithPassword[name=\""+getName()+"\" lastName=\""+getLastName()+"\""+" password="+password+"]}";
    }
}
