package site.metacoding.ex23;

public class ThreadEx01 {

    // main 스레드 시작하면서 메인 메서드 호출
    public static void main(String[] args) {
        System.out.println(1);
        try {
            Thread.sleep(2000); // 2초 있다가 2 출력됨, CPU가 잠들게 함
        } catch (Exception e) {
            e.printStackTrace();
        } // 밀리세컨즈 1/1000초
        System.out.println(2);
    }
}
