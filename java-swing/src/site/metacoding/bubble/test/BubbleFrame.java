package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public void BubbleFrame() {
		initObject(); // 생성자 불러오기
		initSetting();
		initListener();
		setVisible(true);
	}

	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // 레이아웃 null로 설정
		setLocationRelativeTo(null); // 위치 중앙
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누를 시 메인 스택도 함께 종료

	}

	public void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // 배경화면으로 넣기

		player = new Player();
		add(player);
	}

	public void initListener() {
		addKeyListener(new KeyListener() { // 익명 클래스 생성

			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("키보드 프레스 : " + arg0.getKeyCode());
				// 왼쪽은 37, 오른쪽은 39, 위쪽은 38, 아래쪽은 40
				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) { // 오른쪽 방향키 누를 때
					if (!player.isRight()) { // 멈춤 상태에서 출발
						player.right();
					}
				} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) { // 왼쪽 방향키 누를 때
					if (!player.isLeft()) {
						player.left();
					}
				} else if (arg0.getKeyCode() == KeyEvent.VK_UP) {
					if (!player.isJump()) { // 점프 안 한 상태에서 출발
						player.jump();
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setRight(false); // 키보드를 떼면 멈춤 상태로 돌아오기
				} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setLeft(false); // 키보드를 떼면 멈춤 상태로 돌아오기
				}

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public static void main(String[] args) {
		new BubbleFrame();

	}
}
