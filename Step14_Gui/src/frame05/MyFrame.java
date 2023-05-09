package frame05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener{
	
	//생성자
	public MyFrame(String title) {
		super(title);
		
		// setBounds(x, y, width, height) 창의 위치와 크기 설정
		this.setBounds(100, 100, 500, 500); //this 생략가능
		// 이프레임(MyFrame)의 x 버튼 (close 버튼) 을 눌렀을때 프로세스도 같이 종료 되도록 설정 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //=3 설정안하면 x 눌러도 살아있음
		
		//GridLayout 매니저 사용해보기
		setLayout(new FlowLayout());
		
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		//Component a = this;
		
		//ActionListener 인터페이스 type의 참조값을 얻어내서
		ActionListener listener1 = new ActionListener() {
			//이 리스너를 등록한 UI에 어떤 액션이 발생하면 호출되는 메소드
			@Override
			public void actionPerformed(ActionEvent e) {
				//여기서 this 는 컴포넌트는 안됨 > 액션리스너만 가리켜서..
				System.out.println("전송 버튼을 눌렀네?");
				//JOptionPane.showMessageDialog(프레임의 참조값, 띄울 메세지);
				//클래스명 .this 하면 바깥에 있는 클래스로 생성한 객체의 참조값을 가리킬 수 있다.
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다.");
			}
		};
		
		//전송 버튼에 등록하기
		sendBtn.addActionListener(listener1);
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		/*
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("삭제 버튼을 눌렀네?");
			}
		});
		*/
		
		//ActionListener 인터페이스 type 의 참조값을 함수 형태로 전달도 가능
		deleteBtn.addActionListener((e)->{
			System.out.println("삭제 버튼을 눌렀네?");
			//함수 형태의 메소드에서 this 는 바깥 클래스로 생성한 객체의 참조값을 가리킬 수 있다.
			JOptionPane.showMessageDialog(this, "삭제합니다.");
		});
		
		JButton updateBtn = new JButton("수정");
		add(updateBtn);
		//MyFrame을 ActionListener 인터페이스 type 으로 만들 수는 없을까?
		updateBtn.addActionListener(this);
		
		// 프레임을 화면상에 실제 보이게 하기( false 하면 화면에 보이지 않는다 )
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나는 프레임");
		System.out.println("main 메소드가 종료됩니다.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "수정합니다");
	}
}
