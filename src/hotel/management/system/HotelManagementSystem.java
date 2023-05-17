package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class HotelManagementSystem extends JFrame implements ActionListener{

	HotelManagementSystem(){
//		setSize(1366, 565);
//		setLocation(50,150);
		setBounds(100,100,1366,565);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Management System/src/icons/first.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1366,565);
		add(image);
		
		JLabel text = new JLabel ("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430,1000,90);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.PLAIN,50));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(1110,450,150,50);
		next.setBackground(Color.white);
		next.setForeground(Color.MAGENTA);
		next.setFont(new Font("serif",Font.PLAIN,21));
		next.addActionListener(this);
		image.add(next);
		
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try{
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try{
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed (ActionEvent ae) {
		setVisible(false);
		new Login();
	}

	public static void main(String[] args) {
		new HotelManagementSystem();
	}

}
