package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridTest extends MyFrame {
	
	public GridTest() {
		super(300, 300);
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(0, 3));
		
		JButton btn1 = new JButton("버튼1"); // null이라서 위치를 잡아줘 한다.
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		
		setVisible(true);
	}
	
    public static void main(String[] args) {
        new GridTest();
    }

}
