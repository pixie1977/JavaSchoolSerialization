package ru.common;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.common.dto.User;

import java.io.IOException;

public class EntryPointJackson {
    public static void main(String[] args) throws IOException {
        User user = new User("user_name_1", "user_lastname_1");
        System.out.println(user);

        XmlMapper xmlMapper1 = new XmlMapper();
        //xmlMapper1.enable(SerializationFeature.INDENT_OUTPUT);
        // serialize our Object into XML string
        final String xmlString = xmlMapper1.writeValueAsString(user);

        System.out.println("**************************");
        System.out.println(xmlString);
        System.out.println("**************************");
        System.out.println("Size = " + xmlString.getBytes().length);

        XmlMapper xmlMapper2 = new XmlMapper();
        User user2 = xmlMapper2.readValue(xmlString, User.class);
        System.out.println(user2);
    }
}
