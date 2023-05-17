package hotel.management.system;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Search_Room extends JFrame implements ActionListener{
	
	JTable table;
	JButton Back, submit;
	JLabel lblbedtype;
	JComboBox bedtype;
	JCheckBox available;
	
	Search_Room(){
		setLayout(null);
		
		JLabel text = new JLabel("Search For Room");
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text.setBounds(400, 30, 200, 30);
		add(text);
		
		lblbedtype = new JLabel("Search For Room");
		lblbedtype.setBounds(50, 100, 1000, 20);
		add(lblbedtype);
		
		bedtype = new JComboBox (new String[] {"Single Bed", "Double Bed"});
		bedtype.setBounds(170, 100, 150, 25);
		add(bedtype);
		
		available = new JCheckBox("Only Display Available");
		available.setBounds(600, 100, 400, 25);
		add(available);
		
		JLabel l1 = new JLabel("Room No");
		l1.setBounds(0,160,80,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(210,160,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(420,160,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(630,160,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(840,160,80,20);
		add(l5);
		
		table = new JTable();
		table.setBounds(0, 200, 1050, 300);
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
		Back.setBounds(80, 500, 200, 30);
		add(Back);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setBounds(300, 500, 200, 30);
		add(submit);
		
		setBounds(300, 200, 1050, 600);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			try {
				
				String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
				String query2 = "select * from room where availability = 'Available' and bed_type = '"+bedtype.getSelectedItem()+"'";
				
				DBConnection c = new DBConnection();
				ResultSet rs;
				
				if(available.isSelected()) {
					rs = c.s.executeQuery(query2);
				}else {
					rs = c.s.executeQuery(query1);
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
		}else {
			setVisible(false);
			new Reception();
		}
		
		
	}

	public static void main(String[] args) {
		new Search_Room();

	}

	

}
