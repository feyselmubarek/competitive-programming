package app;

import java.util.HashMap;

public class App {

    HashMap<Long, String> tinyUrlHolder = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Codec codec = new Codec();

        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));

        System.out.println(codec.decode(codec.encode("qaqaqa")));
    }
}