package charset;

import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {
    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        getEnglishEncoding();
        getKoreanEncoding();
        getKoeanAdvancedEncoding();
        getKoreanDifferentEncoding();


    }

    private static void getKoeanAdvancedEncoding() {
        System.out.println("한글 인코딩");
        test("뷁", US_ASCII, US_ASCII);
        test("뷁", ISO_8859_1, ISO_8859_1);
        test("뷁", EUC_KR, EUC_KR);
        test("뷁", UTF_8, UTF_8);
        test("뷁", UTF_16BE, UTF_16BE);
        test("뷁", MS_949, MS_949);
    }

    private static void getKoreanEncoding() {
        System.out.println("한글 인코딩");
        test("가", US_ASCII, US_ASCII);
        test("가", ISO_8859_1, ISO_8859_1);
        test("가", EUC_KR, EUC_KR);
        test("가", UTF_8, UTF_8);
        test("가", UTF_16BE, UTF_16BE);
        test("가", MS_949, MS_949);
    }

    private static void getEnglishEncoding() {
        System.out.println("영어 ASCII 인코딩");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1);
        test("A", US_ASCII, EUC_KR);
        test("A", US_ASCII, UTF_8);
        test("A", US_ASCII, UTF_16BE);
        test("A", US_ASCII, MS_949);
    }
   private static void getKoreanDifferentEncoding() {
        System.out.println("한글 디코딩 인코딩 다를 경우");
        test("가", EUC_KR, MS_949);
        test("가", MS_949, EUC_KR);
        test("가", EUC_KR, UTF_8);
        test("가", MS_949, UTF_8);
    }
    private static void getEnglishDifferentEncoding() {
        System.out.println("영어 디코딩 인코딩 다를 경우");
        test("A", EUC_KR, MS_949);
        test("A", MS_949, EUC_KR);
        test("A", EUC_KR, UTF_8);
        test("A", MS_949, UTF_8);
    }

    public static void test(String text, Charset encodingCharset, Charset decodingCharset){
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
                text, encodingCharset, Arrays.toString(encoded), encoded.length,
                decodingCharset, decoded);
    }
}
