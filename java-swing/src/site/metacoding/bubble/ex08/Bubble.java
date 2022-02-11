package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel { // 플레이어한테 의존한다.
	private BubbleFrame context;
	private Player player;
	
	private int x; // 버블의 위치
	private int y;
	
	private ImageIcon bubble, bomb; // 그냥 버블, 터지는 버블
	
	public Bubble(BubbleFrame context) { // 생성자 주입
		this.context = context;
		this.player = context.getPlayer(); // context를 받는 게 편하다.
		
		initObject();
		initSetting();
		left();
		right();
	}
	
	public void initObject() {
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bomb.png");
	}
	
	public void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble); // 먼저 생길 필요는 없고 스페이스 누를 때 생성
		setSize(50, 50); 
		setLocation(x, y);
		
		
	}
	
	public void left() {
		System.out.println("left 메서드 실행");
		new Thread(() -> {
			for(int i = 0; i < 400; i++) { // 끝이 있기 때문에 스레드 종료됨
				System.out.println("x: " + x);
				x = x - 1;
				setLocation(x, y);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void right() {
		System.out.println("right 메서드 실행");
		new Thread(() -> {
			for(int i = 0; i < 400; i++) {
				System.out.println("x: " + x);
				x = x + 1;
				setLocation(x, y);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	}

