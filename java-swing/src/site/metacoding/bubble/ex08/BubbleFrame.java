package site.metacoding.bubble.ex08;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author jeonga-eun 목적 :버블 발사하기 (수평발사만 , 충돌 안하고)
 */

// main을 가진 클래스는 해당 프로그램에 컨텍스트(문맥)를 다 알고 있다.
public class BubbleFrame extends JFrame {
	
	private BubbleFrame context = this; // 버블 프레임의 class 가르킴
	// 쓸 때는 다운캐스팅 해서 사용
	
	private JLabel backgroundMap;
	private Player player;

	int count = 0;
  
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	private void initService() {
		new Thread(new BackgroundMapService(player)).start();
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // add 할 때 위치 지정을 해주어야 한다.

		player = new Player(context);
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

				if (e.getKeyCode() == KeyEvent.VK_RIGHT && player.isRightWallCrash() == false) {// 39임, 16진수
					// 키보드를 누르고 있는 동안 right 메서드를 한 번만 실행하고 싶다.
					if (!player.isRight()) { // 움직이지 않을 때 움직이기 위해서
						player.right();
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT && player.isLeftWallCrash() == false) {
					if (!player.isLeft()) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) { // 이것을 막으면 이벤트 루프 등록을 안 함
					if (player.isUp() == false && player.isDown() == false) { // 업다운이 false일 때면 점프 가능
						player.up(); // 메서드 내부에서 IF 분기 처리는 이벤트 루프에 등록 되지만 실행되지 않음
					}
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE) { // 32
					if(player.getDirection() == 0) {
						player.attack();
					} else if(player.getDirection() == 1)
						player.attack();
					}

			}

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
		new BubbleFrame();

	}
}
