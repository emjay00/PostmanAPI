package org.library;

import java.util.Random;

public class Payload {
    public static String AddBook() {

        Random rand = new Random();
        int upperbound = 1000;
        int random = rand.nextInt(upperbound);

        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"bcd\",\n" +
                "\"aisle\":\"" + random + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }
}
