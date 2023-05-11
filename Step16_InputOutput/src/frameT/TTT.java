package frameT;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TTT extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg;
	JLabel label;
		
	//생성자
	public TTT(String title) {
		super(title);
		// 초기 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//문자열을 한 줄 입력할 수 있는 JTextField 객체 생성
		inputMsg =new JTextField(10);
		JButton sendBtn =new JButton("전송");
		
		//MyFrame을 액션 리스너로 등록한다.
		sendBtn.addActionListener(this);
		add(inputMsg);
		add(sendBtn);
		
		//함수 형태로 액션 리스너를 등록할 수도 있다.
		sendBtn.addActionListener((e)->{
			String msg =inputMsg.getText();
			JOptionPane.showMessageDialog(this, msg);
			label.setText(msg);
		});
		
		// 프레임을 화면상에 실제 보이게 하기( false 하면 화면에 보이지 않는다 )
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new TTT("FFF");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "수정합니다");
	}
}
