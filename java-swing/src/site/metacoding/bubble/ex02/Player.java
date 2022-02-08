package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author jeonga-eun 플레이어는 좌우상하 이동이 가능하다. 점프가 가능하다. 방울 발사
 */

public class Player extends JLabel { // JFrame위에 올려놓았다.

	private int x;
	private int y;
	private ImageIcon playerR;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png"); // setIcon이 호출됨, JLabel 안에 있기 때문.
	}

	private void initSetting() {
		x = 70; // 위치 변경한 것을 적용시키려면 setLocation 해줘야 됨
		y = 535;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent 호출해줌, 레이블만 바꿈
	}
}
