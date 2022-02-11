package site.metacoding.practice;

/*
 * @author 전가은
 * ---생성자 실행 순서----
 * initObject 1번 실행
 * initSetting 2번 실행
 * initListener 3번 실행(default)
 */

public interface Init {
	void initObject();
	void initSetting();
	default void initListener() {}; // default가 있으면 몸체 만들 수 있음
}
