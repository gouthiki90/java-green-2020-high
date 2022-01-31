package site.metacoding.ex21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero02 {
    public static void main(String[] args) {

        // InputMismatchException 입력값 타입 일치하지 않은 예외
        // 통신, 사용자 입력은 반드시 예외처리를 해야 한다.

        boolean check = true;

        while (check) { // 버퍼 비우고 들어옴
            Scanner sc = new Scanner(System.in); // 버퍼를 새로 만듦
            try {
                int x = sc.nextInt(); // 버퍼 저장
                int result = x / 0;
                System.out.println("받은 값 : " + x);

            } catch (Exception e) { // 예외의 최고부모이기 때문에 모든 자식 예외 클래스 다 쳐짐
                System.out.println("========");
                System.out.println(e.getMessage());
                System.out.println("========");
                e.printStackTrace();
                // sc.nextLine(); // 버퍼를 비운다.
            }
        }

        // 애초에 "가"를 넣지 않도록 막아야 한다.
        // 사용자가 무엇을 넣을지 모르기 때문에 처음부터 강제성을 부여해야 한다.
        // 이를 유효성 체크라고 한다.
    }
}
