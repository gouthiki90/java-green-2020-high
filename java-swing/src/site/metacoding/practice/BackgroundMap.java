package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel {
	
	   public ImageIcon getBackgroundMap() {
		      return backgroundMap;
		   }

		   public void setBackgroundMap(ImageIcon backgroundMap) {
		      this.backgroundMap = backgroundMap;
		   }

		   public BufferedImage getImage() {
		      return image;
		   }

		   public void setImage(BufferedImage image) {
		      this.image = image;
		   }  
	
	private ImageIcon backgroundMap; // 눈에 보이는 용
	private BufferedImage image; // 눈에 안 보이는 용
	
	public BackgroundMap() {
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		backgroundMap = new ImageIcon("image/backgroundMap.png");
	    setIcon(backgroundMap); // Div 박스에 이미지 넣기
	}
	
	
}

