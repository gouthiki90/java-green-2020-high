package site.metacoding.practice;

public interface Moveable { // 조이스틱 버튼과 같은 것
	void left();
	void right();
	void up();
	default void down() {} // 버블은 다운이 없다
}
