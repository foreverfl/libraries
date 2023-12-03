/*
 * - 이벤트 리스너/콜백 메서드: 객체가 이벤트 리스너나 콜백 메서드에 자신을 전달하여, 이벤트 발생 시 자신을 참조할 수 있도록 함.
 * - 비교 연산: 객체가 자신과 다른 객체를 비교하는 메서드에 자신을 전달하여, 두 객체 간의 비교를 수행함.
 * - 체인 형태의 메서드 호출: 한 객체가 다른 객체의 메서드를 호출하면서 자신을 전달하여, 여러 객체 간의 상호 작용을 연쇄적으로 수행함.
 * - 상태 관리: 객체가 상태 관리 객체나 트랜잭션 관리자에 자신을 전달하여, 현재 상태나 컨텍스트 정보를 관리하도록 함.
 */

package default_library;

public class this_Instance_as_Parameter {
    static class Object {
        public void myMethod() {
            anotherMethod(this);
        }

        public static void anotherMethod(Object obj) {
            System.out.println("Method called with: " + obj);
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        object.myMethod(); // 현재 객체 인스턴스의 참조 출력
    }
}
