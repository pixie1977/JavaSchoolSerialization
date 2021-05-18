package ru.common;

import ru.common.dto.GoodSerializableUserWithCustomReadWrite;

import java.io.*;

public class EntryPointPersonRestoreCustomSerializableObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        GoodSerializableUserWithCustomReadWrite user = new GoodSerializableUserWithCustomReadWrite(
                "user_name_1", "user_lastname_1");
        System.out.println(user);
        oos.writeObject(user);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(bis);
        GoodSerializableUserWithCustomReadWrite restoredUser = (GoodSerializableUserWithCustomReadWrite) in.readObject();
        System.out.println(restoredUser);
        System.out.println("Size = "+bytes.length);
        System.out.println(restoredUser == user);
        System.out.println(restoredUser.toString().equals(user.toString()));
        oos.flush();
        oos.close();
    }
}
