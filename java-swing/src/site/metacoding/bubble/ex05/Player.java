package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jeonga-eun 목적 : 점프
 */

public class Player extends JLabel { // JFrame위에 올려놓았다.

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	private boolean isRight; // boolean은 is를 붙인다.
	private boolean isLeft;
	private boolean isJump; // 점프 상태(up, down)

	private static final int JUMPSPEED = 2;
	private static final int DOWNSPEED = 2;
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

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png"); // setIcon이 호출됨, JLabel 안에 있기 때문.
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70; // 위치 변경한 것을 적용시키려면 setLocation 해줘야 됨
		y = 535;

		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌, 레이블만 바

		isRight = false;
		isLeft = false;
		isJump = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	public void right() { // 메서드 모듈, 목적을 가지고 있기 때문에
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");

		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// 키보드 윗방향키
	public void jump() {
		// for문으로 돌려야 한다. 키보드를 누를 때 내려가는 것으로 마무리 되기 때문.
		isJump = true;
		System.out.println("점프");

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {// JUMPSPEED가 바뀌어도 높이가 똑같음
				y = y - JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("다운");
			new Thread(() -> {
				for (int i = 0; i < 130 / DOWNSPEED; i++) {
					y = y + DOWNSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
			isJump = false;
		}).start();

	}
}
