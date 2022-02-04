package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


// 임포트 : command + shift + O
public class MyFrame extends JFrame {
    public MyFrame() {
    	super();
        // JFrame을 상속했기 때문에 바로 적어도 된다. this.이 생략 되어있다.
        setSize(600, 400); // w, h
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료

        JPanel panel = (JPanel) getContentPane(); // JFrame의 패널 가져오기
        panel.setLayout(new FlowLayout());
        
        JButton btn1 = new JButton("버튼1");
        JButton btn2 = new JButton("버튼2");
        JButton btn3 = new JButton("버튼3");
        JButton btn4 = new JButton("버튼4");
        
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
    }
    
    public MyFrame(int w, int h) {
        // 생성자 오버로딩 
        setSize(600, 400); // w, h
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료

        JPanel panel = (JPanel) getContentPane(); // JFrame의 패널 가져오기
        panel.setLayout(new FlowLayout());
        
        JButton btn1 = new JButton("버튼1");
        JButton btn2 = new JButton("버튼2");
        JButton btn3 = new JButton("버튼3");
        JButton btn4 = new JButton("버튼4");
        
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
    }
}
