package default_library;

public class Character_getNumericValue {
    public static void main(String[] args) {
        // 문자가 숫자를 나타낼 때
        char ch1 = '5';
        int num1 = Character.getNumericValue(ch1);
        System.out.println("Numeric value of character " + ch1 + " is " + num1);

        // 문자가 알파벳일 때 (16진수 숫자로 간주)
        char ch2 = 'A';
        int num2 = Character.getNumericValue(ch2);
        System.out.println("Numeric value of character " + ch2 + " is " + num2);

        // 문자가 숫자를 나타내지 않을 때
        char ch3 = '!';
        int num3 = Character.getNumericValue(ch3);
        System.out.println("Numeric value of character " + ch3 + " is " + num3);
    }
}
