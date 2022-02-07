package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame {

	JPanel myPanel; // 전역적으로 HEap에 관리
	JButton btn1, btn2;
	JCheckBox checkbox1;
	JLabel labelText, labelImg;

	public EventEx01() { // 생성자 초기화
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);

		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 종료
	}

	private void initObject() {

		myPanel = new JPanel();
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		checkbox1 = new JCheckBox();
		labelText = new JLabel("label1");
		labelImg = new JLabel(new ImageIcon("image/dog.jpg"));

	}

	private void initAssign() {
		add(myPanel); // 컨테이너를 변경하는 것
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkbox1);
		myPanel.add(labelText);
		myPanel.add(labelImg);
	}

	private void initListener() {
		checkbox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) { // e로 체크가 되었는지 안 되었는 지 알려줌
				System.out.println(e.toString()); // 체크가 온오프될 때 나타나는 인터페이스 변수 찾기
				System.out.println(e.getStateChange()); // 온오프를 구분하는 변수 알기

				if (e.getStateChange() == 1) {
					System.out.println("on");
				} else {
					System.out.println("off");
				}
			}

		});

		btn1.addActionListener(new ActionListener() { // 익명 클래스로 인터페이스 new 하기

			// 버튼이 클릭되면 OS가 해당 메서드를 콜백해준다.
			// 이벤트 리스너를 상속했기 때문에 오버라이드함
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭되었습니다.");
			}
		});

		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("버튼2 클릭되었습니다.");
		});
	}

	public static void main(String[] args) {

		new EventEx01();

	}

}
