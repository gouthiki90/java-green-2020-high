package site.metacoding.ex13.enumerate;

import site.metacoding.ex13.BorderLayoutEx01;

interface Direction {
	// interface에 변수를 적으면 public final static 붙음
	String LEFT = "Left";
	String RIGHT = "Right";
}

public class EnumEx01 {
public static void add(String direction) {
	// "Left", "Right"
	if(direction.equals("Left") || direction.equals("Right")) {
		System.out.println("잘 들어왔다.");
	} else {
		System.out.println("잘못 입력.");
	}
}
public static void main(String[]args) {
	add(Direction.LEFT);
}
}
