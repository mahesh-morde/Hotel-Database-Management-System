package hotel.management.system;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class CustomerInfo extends JFrame implements ActionListener{
	
	JTable table;
	JButton Back;
	
	CustomerInfo(){
		setLayout(null);
		
		JLabel l1 = new JLabel("Document Type");
		l1.setBounds(0,10,131,20);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(131,10,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(262,10,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(393,10,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Country");
		l5.setBounds(524,10,80,20);
		add(l5);
		
		JLabel l6 = new JLabel("Room No");
		l6.setBounds(656,10,80,20);
		add(l6);
		
		JLabel l7 = new JLabel("Check in Time");
		l7.setBounds(787,10,190,20);
		add(l7);
		
		JLabel l8 = new JLabel("Deposit");
		l8.setBounds(918,10,190,20);
		add(l8);
		
		table = new JTable();
		table.setBounds(0, 40, 1050, 400);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from customer";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back To Reception");
		Back.addActionListener(this);
		Back.setBounds(150, 500, 200, 30);
		add(Back);
		
		setBounds(230, 200, 1050, 600);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new CustomerInfo();

	}

	

}
