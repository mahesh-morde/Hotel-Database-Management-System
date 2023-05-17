package hotel.management.system;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Room extends JFrame implements ActionListener{
	
	JTable table;
	JButton Back;
	
	Room(){
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Management System/src/icons/eight.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 0, 600, 600);
		add(image);
		
		JLabel l1 = new JLabel("Room No");
		l1.setBounds(0,10,80,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(90,10,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(210,10,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(290,10,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(390,10,80,20);
		add(l5);
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from room";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back To Reception");
		Back.addActionListener(this);
		Back.setBounds(150, 500, 200, 30);
		add(Back);
		
		setBounds(300, 200, 1050, 600);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new Room();

	}

	

}
