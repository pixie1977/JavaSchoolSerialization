package ru.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.common.dto.BigUser;
import ru.common.dto.User;

import java.io.IOException;

public class EntryPointJackson {
    public static void main(String[] args) throws IOException {
        User user1 = new User("user_name_1", "user_lastname_1");
        System.out.println(user1);

        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        final String jsonString =
                objectMapper.writeValueAsString(user1);
        //objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user1);

        System.out.println("**************************");
        System.out.println(jsonString);
        System.out.println("**************************");
        System.out.println("Size = " + jsonString.getBytes().length);

        ObjectMapper objectMapper2 = new ObjectMapper();
        BigUser user2 = objectMapper2.readValue(jsonString, BigUser.class);
        System.out.println(user2);
    }
}
