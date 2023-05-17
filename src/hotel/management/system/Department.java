package hotel.management.system;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Department extends JFrame implements ActionListener{
	
	JTable table;
	JButton Back;
	
	Department(){
		setLayout(null);
		
		JLabel l1 = new JLabel("Department");
		l1.setBounds(0,10,80,20);
		add(l1);
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(350,10,80,20);
		add(l2);
		
		Back = new JButton("Back To Reception");
		Back.addActionListener(this);
		Back.setBounds(150, 160, 200, 30);
		add(Back);
		
		
		table = new JTable();
		table.setBounds(0, 40, 700, 400);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from department";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back To Reception");
		Back.addActionListener(this);
		Back.setBounds(280, 350, 120, 30);
		add(Back);
		
		setBounds(400, 200, 500, 270);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
		
	}

	public static void main(String[] args) {
		new Department ();

	}

	

}
