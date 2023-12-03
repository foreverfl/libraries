package default_library;

public class java_lang_String_join {
    public static void main(String[] args) {
        CharSequence delimiter = ", "; // 구분자
        CharSequence[] elements = { "Apple", "Banana", "Cherry", "Date" }; // 결합할 문자열
        String result = String.join(delimiter, elements);
        System.out.println(result);
    }
}
