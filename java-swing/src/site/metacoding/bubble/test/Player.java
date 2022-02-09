package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	private int x; // 위치 좌표
	private int y;
	private ImageIcon playerR, playerL; // 오른쪽 모습 이미지

	private boolean isRight; // 게터 세터 만들기, 상태를 행위로 바꾸어야 하기 때문에
	private boolean isLeft;
	private boolean isJump;

	private static final int JUMPSPEED = 2; // 변하지 않는 값이기 때문에 상수로 지정하기
	private static final int SPEED = 4;

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public void player() {
		initSetting(); // 생성자 불러오기
		initObject();

	}

	public void initSetting() {

		playerR = new ImageIcon("image/playerR.png"); // setIcon 자동 호출
		playerL = new ImageIcon("image/playerL.png");

	}

	public void initObject() {

		x = 70; // 위치 지정
		y = 535;

		setIcon(playerR); // 그림 다시 그리기
		setSize(50, 50); // 사이즈 잡기
		setLocation(x, y); // 위치를 잡아줘야 띄울 수 있음

		isRight = false; // 기본값을 거짓으로 해주어야 멈춤 상태에서 출발할 수 있다.
		isLeft = false;

	}

	public void left() { // 왼쪽 이동
		setIcon(playerL); // 이미지 지정
		System.out.println("왼쪽 이동");

		new Thread(() -> { // 람다로 스레드 만들기
			x = x + SPEED;
			setLocation(x, y); // 위치 지정
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void right() { // 오른쪽 이동
		setIcon(playerR);
		System.out.println("오른쪽 이동");

		new Thread(() -> {
			x = x + SPEED;
			setLocation(x, y);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

	}

	public void jump() {
		isJump = true;
		System.out.println("점프");

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // 위치 지정
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("다운");
			new Thread(() -> {
				for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED 값이 바뀌어도 비율이 일정하다
					y = y + JUMPSPEED;
					setLocation(x, y); // 위치 지정
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
			isJump = false; // 점프 이벤트 끝나고 상태 변하기
		}).start();

	}

}
