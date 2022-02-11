package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {
	
	private static final String TAG = "Player:";
	
	// 컴포지션
	private BackgroundMap backgroundMap;
	private Player player;
	
	private ImageIcon playerR, playerL;
	private int x;
	private int y;
	
	private boolean isLeft, isRight, isUp, isDown;
	
	private boolean isLeftWallCrash, isRightWallCrash;
	

	public boolean isLeftWallCrash() {
		return isLeftWallCrash;
	}

	public void setLeftWallCrash(boolean isLeftWallCrash) {
		this.isLeftWallCrash = isLeftWallCrash;
	}

	public boolean isRightWallCrash() {
		return isRightWallCrash;
	}

	public void setRightWallCrash(boolean isRightWallCrash) {
		this.isRightWallCrash = isRightWallCrash;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public static String getTag() {
		return TAG;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public Player(BackgroundMap backgroundMap) {
		this.backgroundMap = backgroundMap;
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
		
		x = 70;
		y = 535;
		
		setIcon(playerR);
		setIcon(playerL);
		setSize(50, 50);
		setLocation(x, y); // JLabel의 위치
		
		isLeft = false;
		isRight = false;
		
		isLeftWallCrash = false;
		isRightWallCrash = false;
	}
	
	public void 바닥충돌감지() {
		//System.out.println(TAG + "바닥충돌계산중");
		
		int bottomColor = backgroundMap.getImage().getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1
		
		if(bottomColor == -2) { // 바닥이 흰색
			System.out.println("바닥이 흰색");
			down();
			
		} else if(bottomColor != -2) { // 바닥에 장애물
			System.out.println("바닥에 장애물");
			isDown = false;
			
		}
	}
	
	public void 왼쪽벽충돌감지() {
		// System.out.println(TAG + "왼쪽충돌계산 중");
		
		Color leftColor = new Color(backgroundMap.getImage().getRGB(player.getX() - 10, player.getY() + 25));
		
		if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
		System.out.println("왼쪽 벽에 충돌");
		player.setLeftWallCrash(true);
		player.setLeft(false);
		}
	}
	
	public void 오른쪽벽충돌감지() {
		Color rightColor = new Color(backgroundMap.getImage().getRGB(player.getX() + 50 + 15, player.getY() + 25));
		
	if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
		System.out.println("오른쪽 벽에 충돌");
		player.setRightWallCrash(true);
		player.setRight(false);
		
	}
	}

	@Override
	public void left() {
		System.out.println(TAG + "left()");
		
		isLeft = true;
		setIcon(playerL);
		new Thread(()->{
			try {
				while(isLeft) {
					x = x - 4;
					setLocation(x, y); // paintComponent() 자동 호출돼서 내부적으로 Player가 repaint된다.
					Thread.sleep(10);
					
					왼쪽벽충돌감지();
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	@Override
	public void right() {
		System.out.println(TAG + "right()");
		
		isRight = true;
		setIcon(playerR);
		new Thread(()->{
			try {
				while(isRight) {
					x = x + 4;
					setLocation(x, y); // paintComponent() 자동 호출돼서 내부적으로 Player가 repaint된다.
					Thread.sleep(10);
					
					오른쪽벽충돌감지();
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	} // stack이 종료될 대 repaint 실행됨

	@Override
	public void up() {
		System.out.println(TAG + "up");
	}
	
	@Override
	public void down() {
		// 바닥충돌감지();
		System.out.println(TAG + "down");
	}

}
