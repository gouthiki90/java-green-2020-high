package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Init{
	
	private static final String TAG = "BubbleApp : ";
	private BubbleApp mContext = this; // 이름 충돌 때문에 myContext
	
	private BackgroundMap backgroundMap;
	private Player player;
	
	
	public BubbleApp() {
		//System.out.println(TAG + "생성자"); // 무슨 클래스에서 실행되는 지 남기는 로그
		
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap();
		setContentPane(backgroundMap); // JFrame의 백그라운드로 붙이기
		player = new Player(backgroundMap);
		
		add(player);
	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
	    getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
	    setLocationRelativeTo(null); // 가운데 배치
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
		
	}
	@Override
	public void initListener() {
		mContext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) { // 값을 넣고 (switch 값! == case 값)
				case KeyEvent.VK_RIGHT: // 값이라면을 case로 함
					// 내부
					if(player.isRight() == false) {
						player.right();
					}
					break; // switch가 종료됨
				case KeyEvent.VK_LEFT: // 값이라면을 case로 함
					//내부
					if(player.isLeft() == false && player.isLeftWallCrash() == false) {
						System.out.println(player.isLeft());
						player.left();
					}
					break;
				case KeyEvent.VK_UP: // 값이라면을 case로 함
					//내부
					player.up();
					break;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {// 39임, 16진수
					// 키보드 뗄 때 false
					// isRight를 flase
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 flase
					player.setLeft(false);
			}
			}
		}); // JFrame에 만들기
	}
	
	public static void main(String[] args) {
		new BubbleApp();

	}
}
