package site.metacoding.bubble.ex04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jeonga-eun 목적 : 스무스한 좌우 이동
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
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

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {// OS가 e를 인식
				// System.out.println("키보드 프레스 : " + e.getKeyCode());
				// 왼쪽은 37, 오른쪽은 39, 위쪽은 38, 아래쪽은 40

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {// 39임, 16진수
					// 키보드를 누르고 있는 동안 right 메서드를 한 번만 실행하고 싶다.
					if (!player.isRight()) { // 움직이지 않을 때 움직이기 위해서
						player.right();
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!player.isLeft()) {
						player.left();
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드 릴리즈");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {// 39임, 16진수
					// 키보드 뗄 때 false
					// isRight를 flase
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 flase
					player.setLeft(false);
				}
			}

		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu

	}

}
