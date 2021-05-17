package ru.common;

import ru.common.dto.BadSerializableUser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static ru.common.Utils.Utils.byteArrayToFormattedHex;

public class EntryPointBadPerson {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        BadSerializableUser user = new BadSerializableUser("user_name_1", "user_lastname_1");
        System.out.println(user);
        oos.writeObject(user);
        byte[] bytes = bos.toByteArray();
        System.out.println(byteArrayToFormattedHex(bytes));
        System.out.println("Size = "+bytes.length);
        oos.flush();
        oos.close();
    }
}
