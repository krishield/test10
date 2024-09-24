package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Main {

    static class User {
        private String name;
        private int age;

        public User() {}

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("Alice", 30);

        try {
            // Serialize the User object to JSON
            String jsonString = objectMapper.writeValueAsString(user);
            System.out.println("Serialized JSON: " + jsonString);

            // Deserialize the JSON back to a User object
            User deserializedUser = objectMapper.readValue(jsonString, User.class);
            System.out.println("Deserialized User: " + deserializedUser);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
