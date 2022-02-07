package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

public class BorderLayoutEx01 extends MyFrame {
	public BorderLayoutEx01() {
		super(500, 500);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new BorderLayout());

		JButton btnNorth = new JButton("북쪽");
		JButton btnEast = new JButton("동쪽");
		JButton btnWest = new JButton("서쪽");
		JButton btnSouth = new JButton("남쪽");
		JButton btnCenter = new JButton("가운데");

		panel.add(btnNorth, BorderConstant.NORTH);
		panel.add(btnEast, BorderConstant.EAST);
		panel.add(btnWest, BorderConstant.WEST);
		panel.add(btnSouth, BorderConstant.SOUTH);
		panel.add(btnCenter, BorderConstant.CENTER);

		// 레이아웃으로 불러오기 가능
		panel.add(btnNorth, BorderLayout.NORTH);
		panel.add(btnEast, BorderLayout.EAST);
		panel.add(btnWest, BorderLayout.WEST);
		panel.add(btnSouth, BorderLayout.SOUTH);
		panel.add(btnCenter, BorderLayout.CENTER);

		setVisible(true); // paint method
	}

	public static void main(String[] args) {
		new BorderLayoutEx01();
	}
}