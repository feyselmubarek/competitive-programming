package app;

import java.util.HashMap;

public class Codec {
    HashMap<Long, String> tinyUrlHolder = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long hash = 101;

        for (int i = 0; i < longUrl.length(); i++) {
            hash += hash + longUrl.charAt(i);
        }

        tinyUrlHolder.put(hash, longUrl);

        return "http://tinyurl.com/" + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        long hash = Long.parseLong(shortUrl.split("/")[3]);

        return tinyUrlHolder.get(hash);
    }
}