package site.metacoding.ex23;

class Monster implements Runnable {
    int x = 10;
    int speed = 1; // 2초씩 자고 움직임
    boolean check = true;

    @Override
    public void run() {
        while (check) {
            try {
                Thread.sleep(1000);
                x = x - speed;
                System.out.println("몬스터의 현재 위치" + x);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

class Host implements Runnable {
    int x = 0; // 몬스터의 좌표에 가면 몬스터 죽음
    int speed = 2; // 1씩 이동
    boolean check = true;

    @Override
    public void run() {
        while (check) {
            try {
                Thread.sleep(1000);
                x = x + speed;
                System.out.println("플레이어의 현재 위치" + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

// 실습 -> Host의 speed를 2로 만들고, Monster는 잠자지 않는다.

// 스레드가 문맥교환을 할 때는 내부적으로 0.000001초라도 졸고 넘어간다.
// 하나의 프로세스 안에 여러개의 스레드가 동작한다.
// 스레드 일시 정지 하는 법
public class ThreadEx05 {
    public static void main(String[] args) {
        Monster monster = new Monster();
        Host host = new Host();

        // 클래스의 상태의 변수 주소를 가져오려면 객체를 들고 오는 수밖에 없다.
        Thread p1 = new Thread(monster);
        Thread p2 = new Thread(host);

        p1.start();
        p2.start();

        while (true) {
            if (host.x >= monster.x) {
                host.check = false; // run 반복문 종료 시키기
                monster.check = false;
                System.out.println("몬스터가 죽었습니다... R.I.P");
                break;
            } else {
                System.out.println("~~~~ 게임 진행 중 ~~~~");
                try {
                    Thread.sleep(100);
                    // 메인 스레드가 쉴 때가 있어야 다른 스레드로 옮길 수 있다.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
