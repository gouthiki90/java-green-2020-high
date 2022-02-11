package site.metacoding.bubble.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 서비스는 독립적인 스레드로 돌려야 한다.
public class BackgroundMapService implements Runnable {

	// 컴포지션
	private Player player;
	private BufferedImage image;

	// 컴포지션을 위한 기술 - 의존성 주입(생성자를 통해서 주입) = DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;

		try {
			// raw하게 읽는다는 것 : 날 것 그대로 읽는 것
			image = ImageIO.read(new File("image/backgroundMapService.png"));
			// System.out.println(image);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) { // 서비스니까 게임이 종료될 때까지 반복한다.
			try {
				// 색상 계산
				Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				// 왼쪽 벽 충돌과 오른쪽 벽 충돌 계산
				Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25)); // 캐릭터 이미지의 x좌표에서 10
																									// 빼기, y좌표와 맞물리는 곳
				Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));

				// System.out.println(image.getRGB(player.getX(), player.getY() + 50 + 5));

				int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
						+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

				if (bottomColor != -2) { // 바텀 충돌 상태
					player.setDown(false);
				} else if (bottomColor == -2) {
					if (player.isDown() == false && player.isUp() == false) { // 다운 상태도 업 상태도 아닐 때 내려가기
						player.down();
					}
				}

				if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
					System.out.println("왼쪽 벽에 충돌함");
					player.setLeftWallCrash(true);
					player.setLeft(false); // while문이 멈춤
				} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
					System.out.println("오른쪽 벽에 충돌함");
					player.setRightWallCrash(true); // 벽 충돌
					player.setRight(false); // 이동 못함
				} else {
					player.setRightWallCrash(false); // 충돌하지 않으면 이동 가능
					player.setLeftWallCrash(false);
				}

//				System.out.println(color.getRed());
//				System.out.println(color.getGreen());
//				System.out.println(color.getBlue());
//				System.out.println("=================");
				// 쉬는 타임을 주니까 while을 돌려도 색깔 정보가 나온다.
				Thread.sleep(10); // 충돌감지를 미세하게 하는 조절법, 0.01초
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
