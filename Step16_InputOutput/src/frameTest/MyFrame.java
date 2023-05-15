package frameTest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	JButton addBtn, updateBtn, deleteBtn;
	JTextArea num, name, addr;
	
	public MyFrame(String title) {
        super(title);

        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JTextField numText=new JTextField(20);
        JTextField nameText=new JTextField(20);
        JTextField addrText=new JTextField(20);
        
        JButton addBtn=new JButton("추가");
        JButton updateBtn=new JButton("수정");
        JButton deleteBtn=new JButton("삭제");
        
        add(num);
        add(name);
        add(addr);
        add(addBtn);
        add(updateBtn);
        add(deleteBtn);
        
        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        
        addBtn.setActionCommand("add");
        updateBtn.setActionCommand("update");
        deleteBtn.setActionCommand("delete");
        
        setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("DataBase SQL");
	}
	
   @Override
   public void actionPerformed(ActionEvent e) {
	   //DB 연결객체를 담을 지역 변수 만들기
	   Connection conn = null;
	   try {
		   //오라클 드라이버 로딩
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   //접속할 DB 의 정보 @아이피주소:port번호:db이름
		   String url="jdbc:oracle:thin:@localhost:1521:xe";
		   //계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
		   conn= DriverManager.getConnection(url, "scott", "tiger");
		   //예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
		   System.out.println("Oracle DB 접속 성공");
	   } catch (Exception e1) {
		   e1.printStackTrace();
	   }
	   String numD=num.getText();
	   String nameD=name.getText();
	   String addrD=addr.getText();
	   
	   String cmd=e.getActionCommand();
	   PreparedStatement pstmt=null;
	   
//	   if(cmd.equals("add")) {
//	        try {
//				String sql="INSERT INTO member"
//				        + " (num, name, addr)"
//				        + " VALUES(?, ?, ?)";
//				pstmt=conn.prepareStatement(sql);
//				pstmt.setInt(1, num); 
//				pstmt.setString(2, name); 
//				pstmt.setString(3, addr); 
//				pstmt.executeUpdate();
//				System.out.println("회원 정보를 추가했습니다.");
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
	   }
   }
   
}
