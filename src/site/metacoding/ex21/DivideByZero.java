package site.metacoding.ex21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // InputMismatchException 입력값 타입 일치하지 않은 예외
        // 통신, 사용자 입력은 반드시 예외처리를 해야 한다.

        boolean check = true;

        try {

            int x = sc.nextInt();
            int result = x / 0;
            System.out.println("받은 값 : " + x);

        } catch (InputMismatchException e) {
            System.out.println("========");
            System.out.println("문자 넣지마!");
            System.out.println("========");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("========");
            System.out.println("0 나누지 마!");
            System.out.println("========");
            e.printStackTrace();
        }

        // 애초에 "가"를 넣지 않도록 막아야 한다.
        // 사용자가 무엇을 넣을지 모르기 때문에 처음부터 강제성을 부여해야 한다.
        // 이를 유효성 체크라고 한다.
    }
}
