package site.metacoding.ex23;

class NewWorker implements Runnable { // 러너블 인터페이스 구현

    // 타겟
    // 추상 메서드를 오버라이드 함
    // run 메소드 오버라이드 해서 run만 해야 된다는 강제성 부여
    @Override
    public void run() { // new worker의 타겟
        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("뉴워커 스레드 : " + i);
                Thread.sleep(1000); // 1초씩 잠듦
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}

public class ThreadEx02 {

    // main 스레드의 타겟은 main 메서드 (task, 임무)
    public static void main(String[] args) {
        // NewWorker 생성
        Thread newWorker = new Thread(new NewWorker());
        // 스레드 생성, 어떤 메인 메서드를 실행시켜야 하지?
        // Thread는 메서드가 오버로딩 되어있다.
        // 타겟 스레드 메서드는 러너블 타입, 인터페이스라서 new 못함
        // 때문에 상속해서 실행해야 되기 때문에 class 만듦
        newWorker.start(); // 스레드 시작
        // run() 메서드 호출
        // 메인과 동시에 실행됨
        // 일에 순서가 없기 때문에 비동기 프로그램이 된다

        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("메인 스레드 : " + i);
                Thread.sleep(1000); // 1초씩 잠듦
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
