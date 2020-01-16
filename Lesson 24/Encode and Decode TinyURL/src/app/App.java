package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().encode("ababhavsavhsasasahasqa"));
        System.out.println(new App().encode("baaq"));
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long hash = 11;

        for (int i = 0; i < longUrl.length(); i++) {
            hash += hash + longUrl.charAt(i);
        }

        return "http://tinyurl.com/" + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        String[] arr = shortUrl.split("/");

        String hashedCode = arr[arr.length - 1];

        return shortUrl;
    }
}