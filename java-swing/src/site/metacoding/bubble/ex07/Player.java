package site.metacoding.bubble.ex07;

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
	private boolean up; // 점프 상태(up, down)
	private boolean down;

	private static final int JUMPSPEED = 2;
	private static final int DOWNSPEED = 2;
	private static final int SPEED = 4;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean downWallCrash;

	public boolean isDownWallCrash() {
		return downWallCrash;
	}

	public void setDownWallCrash(boolean downWallCrash) {
		this.downWallCrash = downWallCrash;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
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
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;
		downWallCrash = false;
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
	public void up() {
		// for문으로 돌려야 한다. 키보드를 누를 때 내려가는 것으로 마무리 되기 때문.
		up = true;
		// System.out.println("up");

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
			up = false;
			down(); // 업하면 다운하도록 메서드 호출
		}).start();

	}

	// 키보드 윗방향키
	public void down() {
		// for문으로 돌려야 한다. 키보드를 누를 때 내려가는 것으로 마무리 되기 때문.
		down = true;
		// System.out.println("down");
		new Thread(() -> {
			while (down) {
				y = y + DOWNSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();

	}
}
