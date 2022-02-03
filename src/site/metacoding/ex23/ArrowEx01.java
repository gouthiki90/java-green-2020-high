package site.metacoding.ex23;

interface Remocon {
    public abstract void on(); // on을 해야 된다는 강제성 부여
}

class Samsung {
    public void 수리를위한테스트(Remocon r) {
        r.on();
    }
}

public class ArrowEx01 {
    public static void main(String[] args) {
        Samsung s = new Samsung();
        s.수리를위한테스트(new Remocon() { // 익명 클래스

            @Override
            public void on() {

            }

        });

        s.수리를위한테스트(() -> { // 메서드를 전달할 수 있다. 실제로는 익명 클래스가 전달되는 것이다.
            // 화살표 함수는 추상 메서드가 1개만 있을 때 사용 가능하다.
            // 화살표를 가르키는 것이 어떤 메서드인지 확신할 수 없기 때문이다.
        });
    }
}
