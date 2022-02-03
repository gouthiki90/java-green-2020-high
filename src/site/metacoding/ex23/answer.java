package site.metacoding.ex23;

class Monsters implements Runnable {
    int x = 10;
    int speed = 1; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("몬스터의 좌표" + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class Hosts implements Runnable {
    int x = 0;
    int speed = 2; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("플레이어의 좌표" + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

public class answer {
    public static void main(String[] args) {
        Monsters monster = new Monsters();
        Hosts host = new Hosts();

        Thread monsterThread = new Thread(monster);
        Thread hostThread = new Thread(host);

        hostThread.start();
        monsterThread.start();

        while (true) {
            if (host.x >= monster.x) {
                try {
                    System.out.println("몬스터가 죽었습니다. 게임이 종료됩니다.");
                    // 1. 몬스터 종료
                    monster.isActive = false;
                    // 2. 호스트 종료
                    host.isActive = false;
                    // 3. 메인 종료
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    Thread.sleep(100);
                    System.out.println("게임 진행 중......");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
