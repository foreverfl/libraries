package default_library;

public class String_format {
    public static void main(String[] args) {
        int number = 255;

        // 10진수 포맷
        String decimal = String.format("%d", number);
        System.out.println(decimal); // "255"

        // 8진수 포맷
        String octal = String.format("%o", number);
        System.out.println(octal); // "377"

        // 16진수 포맷, 소문자
        String hexLower = String.format("%x", number);
        System.out.println(hexLower); // "ff"

        // 16진수 포맷, 대문자
        String hexUpper = String.format("%X", number);
        System.out.println(hexUpper); // "FF"

        // 2진수 포맷 (Java에는 내장된 포맷 지정자가 없으므로 Integer 클래스를 사용)
        String binary = String.format("%s", Integer.toBinaryString(number));
        System.out.println(binary); // "11111111"

        // 각각의 포맷에 최소 자리수 지정 (8자리로 표현, 부족한 경우 앞을 0으로 채움)
        String formattedDecimal = String.format("%08d", number);
        System.out.println(formattedDecimal); // "00000255"

        String formattedOctal = String.format("%08o", number);
        System.out.println(formattedOctal); // "00000377"

        String formattedHexLower = String.format("%08x", number);
        System.out.println(formattedHexLower); // "000000ff"

        String formattedHexUpper = String.format("%08X", number);
        System.out.println(formattedHexUpper); // "000000FF"
    }
}
