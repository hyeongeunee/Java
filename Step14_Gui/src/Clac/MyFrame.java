package Clac;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.w3c.dom.ls.LSOutput;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg1, inputMsg2;
	JLabel label, result;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		// 초기 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//문자열을 한 줄 입력할 수 있는 JTextField 객체 생성
		inputMsg1 =new JTextField(10);
		JButton addBtn =new JButton("+");
		JButton subBtn =new JButton("-");
		JButton mulBtn =new JButton("x");
		JButton divBtn =new JButton("/");
		inputMsg2 =new JTextField(10);
		
		//문자열을 단순히 출력할 수 있는 JLabel 객체
		JLabel label = new JLabel("=");
		JLabel result = new JLabel("0");
		
		//MyFrame을 액션 리스너로 등록한다.
		//sendBtn.addActionListener(this);
		
		//함수 형태로 액션 리스너를 등록할 수도 있다.
		addBtn.addActionListener((e)->{
			String msg =inputMsg1.getText();
			String msg2 =inputMsg2.getText();
			double addRes = Integer.parseInt(msg+msg2);
			JOptionPane.showMessageDialog(this, addRes);
			result.setText((addRes);
		});
		subBtn.addActionListener((e)->{
			String msg =inputMsg1.getText();
			String msg2 =inputMsg2.getText();
			JOptionPane.showMessageDialog(this, msg+msg2);
			result.setText(msg+msg2);
		});
		mulBtn.addActionListener((e)->{
			String msg =inputMsg1.getText();
			String msg2 =inputMsg2.getText();
			JOptionPane.showMessageDialog(this, msg+msg2);
			result.setText(msg+msg2);
		});
		divBtn.addActionListener((e)->{
			String msg =inputMsg1.getText();
			String msg2 =inputMsg2.getText();
			JOptionPane.showMessageDialog(this, msg+msg2);
			result.setText(msg+msg2);
		});
		
		//프레임이 UI를 추가한다.
		add(inputMsg1);
		add(addBtn);
		add(subBtn);
		add(mulBtn);
		add(divBtn);
		add(inputMsg2);
		add(label);
		add(result);
		
		//UI를 모두 배치하고 나중에 호출하는 것이 원칙이다.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("계산기");
	}
}
