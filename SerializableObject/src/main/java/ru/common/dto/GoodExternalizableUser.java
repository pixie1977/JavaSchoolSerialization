package ru.common.dto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class GoodExternalizableUser implements Externalizable {
    private String name;
    private String lastName;

    //try to comment! ;)
    public GoodExternalizableUser() {
    }

    public GoodExternalizableUser(String name, String lastName) {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this);
//        out.writeObject(name);
//        out.writeObject(lastName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readObject();
//        name = (String) in.readObject();
//        lastName = (String) in.readObject();
    }
}
