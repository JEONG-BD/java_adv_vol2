package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        // 이용 가능한 Charset 자바 + OS 
        charsets.forEach((name, charset) -> System.out.println("name : " + name + " charset : " + charset ));


        extractedMs949();
        extractedUTF8();
        extractedDefault();
    }

    private static void extractedDefault() {
        // default
        Charset charset = Charset.defaultCharset();
        System.out.println("default " + charset);
    }

    private static void extractedUTF8() {
        Charset utf8 = Charset.forName("UTF-8");
        System.out.println("utf8 = " + utf8);
        Charset utf81 = StandardCharsets.UTF_8;
    }


    private static void extractedMs949() {
        Charset ms949 = Charset.forName("MS949");
        System.out.println("ms949 = " + ms949);
        Set<String> aliases = ms949.aliases();
        aliases.stream()
                .forEach(System.out::println);
    }
}
