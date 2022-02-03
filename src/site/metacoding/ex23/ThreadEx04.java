package site.metacoding.ex23;

public class ThreadEx04 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> { // 자동으로 run 메서드로 인식이 된다.
            // 들어올 수 있는 타입은 러너블 밖에 없기 때문이다.
            // 화살표 함수, 중괄호 내부 스택은 런 메서드로 인식이 된다.
            // 결국 목적은 타겟만 넘기는 것이기 때문에 이렇게가 가능하다.

            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println("띠용");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
        t1.start();
    }

}
