/*
 * - 기본값 설정: 여러 생성자가 있을 때, 하나의 생성자에서 다른 생성자를 호출하여 기본값을 설정하거나 중복 코드를 피하기 위해 사용.
 * - 다양한 초기화 옵션 제공: 객체를 다양한 방법으로 초기화할 수 있도록 여러 생성자를 제공하면서, 중복 코드를 줄이기 위해 사용.
 * - 객체 초기화의 일관성 유지: 모든 생성자가 동일한 초기화 블록을 거치도록 하여 객체의 일관된 상태를 보장.
 */

package default_library;

public class this_Constructor_Overloading {
    static class Object {
        private int x, y;

        public Object() {
            this(0, 0);
        }

        public Object(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.x + ", " + object.y); // "0, 0" 출력
    }
}
