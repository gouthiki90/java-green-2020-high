package site.metacoding.practice;

interface knife {
	void attack();
	void cook();
}

abstract class 요리사어댑터 implements knife {
	public void attack() {} // 추상 클래스이기 때문에 구현하지 않아도 됨

}

abstract class 싸움꾼어댑터 implements knife { // 한 번 걸러짐
	public void cook() {}
	}


class 백종원 extends 요리사어댑터 {

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		
	}
	
}

class 검투사 extends 싸움꾼어댑터 {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}

public class PattenTest {

}
