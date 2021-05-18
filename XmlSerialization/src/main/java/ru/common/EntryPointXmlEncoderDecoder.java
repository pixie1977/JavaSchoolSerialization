package ru.common;


import ru.common.dto.User;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EntryPointXmlEncoderDecoder {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        User user = new User("user_name_1", "user_lastname_1");
        System.out.println(user);

        XMLEncoder encoder = new XMLEncoder(bos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                e.printStackTrace();
            }
        });
        encoder.writeObject(user);
        //пока не закроется - не запишет корректно
        encoder.close();

        byte[] bytes = bos.toByteArray();
        System.out.println(new String(bytes));
        System.out.println("Size = " + bytes.length);

        bos.flush();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        XMLDecoder decoder = new XMLDecoder(bis);
        User user2 = (User) decoder.readObject();
        System.out.println(user2);
        decoder.close();
        bis.close();
    }
}
