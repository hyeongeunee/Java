package test.mypac;

public class RRemocon implements Remocon{
	@Override
	public void down() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("down");
	}
	@Override
	public void up() {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("up");
	}
	
	//그런데 나는 내가 사용할 편리한 메소드를 하나 더 만들고 싶다.
	public void reserve() {
		System.out.println("전원 off 예약");
	}
}
