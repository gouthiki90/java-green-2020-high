package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jeonga-eun 플레이어는 좌우상하 이동이 가능하다. 점프가 가능하다. 방울 발
 */

public class Player extends JLabel { // JFrame위에 올려놓았다.

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	private boolean isRight; // boolean은 is를 붙인다.
	private boolean isLeft;

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
	}

	public void left() {
		setIcon(playerL);
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			x = x + 10;
			setLocation(x, y);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

	}

	public void right() { // 메서드 모듈, 목적을 가지고 있기 때문에
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");

		new Thread(() -> {
			while (isRight) {
				x = x + 10;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
}
