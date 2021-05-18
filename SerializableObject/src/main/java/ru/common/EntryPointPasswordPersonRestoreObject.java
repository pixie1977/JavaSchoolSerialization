package ru.common;

import ru.common.dto.UserWithPassword;

import java.io.*;

public class EntryPointPasswordPersonRestoreObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        UserWithPassword user = new UserWithPassword(
                "user_name_1", "user_lastname_1", "password");
        System.out.println(user);
        oos.writeObject(user);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(bis);
        UserWithPassword restoredUser = (UserWithPassword) in.readObject();
        System.out.println("Size = "+bytes.length);
        System.out.println(restoredUser == user);
        System.out.println(restoredUser.toString().equals(user.toString()));
        oos.flush();
        oos.close();
    }
}
