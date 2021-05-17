package ru.common;

import ru.common.dto.NotSerializableUser;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        NotSerializableUser user = new NotSerializableUser("user_name_1", "user_lastname_1");
        System.out.println(user);
        oos.writeObject(user);
        byte[] bytes = bos.toByteArray();
        String hex = javax.xml.bind.DatatypeConverter.printHexBinary(bytes);
        System.out.println(hex);
        oos.flush();
        oos.close();
    }
}
