package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jeonga-eun 목적 : 배경화면 설정, 캐릭터 추가
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // add 할 때 위치 지정을 해주어야 한다.

		player = new Player();
		add(player);
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 제이페널의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
