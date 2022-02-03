package site.metacoding.ex23;

import java.util.Scanner;

// 익명 클래스를 만들어 보자
// 추상 클래스와 인터페이스를 new할 수 없는 이유?
// 개념적 : 추상적이기 때문, 문법 : 추상 메서드를 가지고 있기 때문
public class ThreadEx03 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        Thread t1 = new Thread(new Runnable() { // 러너블 인터페이스를 익명 클래스로 생성

            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    try {
                        System.out.println("메인 스레드" + i);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("메인 스레드 종료");
            }

        });
        t1.start(); // 스레드 시작
        // 클래스를 만들 필요 없이 익명 클래스를 통해서 추상 메서드를 오버라이드 한다.
    }

}
