package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
    public MyFrame() {
        // JFrame을 상속했기 때문에 바로 적어도 된다. this.이 생략 되어있다.
        setSize(600, 400); // w, h
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료

        JPanel panel = (JPanel) getContentPane(); // JFrame의 패널 가져오기
        // panel.setLayout();
        JButton btn1 = new JButton("버튼1");
        panel.add(btn1);

        setVisible(true);
    }
}
