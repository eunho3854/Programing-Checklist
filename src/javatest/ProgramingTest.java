package javatest;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class ProgramingTest extends JFrame {
	
	private JLabel la1, la2;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btn1, btn2;
	private Container c;
	private GridLayout grid;
	
	public void 문자전송(String to, String text) {

		String api_key = "NCSBJ0WWH1LZENN8";
	    String api_secret = "CZC2IJ3SFZZ4UUDYQOBGWM3RWDX7M2MQ";
	    Message coolsms = new Message(api_key, api_secret);

	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", to);
	    params.put("from", "01063003854");
	    params.put("type", "LMS");
	    params.put("text", text);
	    params.put("app_version", "test app 1.2");

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println("메시지가 전송되었습니다.");
	      System.out.println(obj.toString());
	     
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}
	
		
	public ProgramingTest() {
		
		setTitle("자바 시험");
		setSize(500, 300);
		
		la1 = new JLabel("전화번호 ");
		la2 = new JLabel("메시지 ");
		
		tf1 = new JTextField("");
		tf2 = new JTextField("");
		
		btn1 = new JButton("전송");
		btn2 = new JButton("초기화");
		
		grid = new GridLayout(3,2);
		
		c = getContentPane();
		c.setLayout(grid);
		
		c.add(la1);
		c.add(tf1);
		
		c.add(la2);
		c.add(tf2);
			
		c.add(btn1);
		c.add(btn2);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				문자전송(tf1.getText(), tf2.getText());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
			}
		});
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new ProgramingTest();
	}

}
