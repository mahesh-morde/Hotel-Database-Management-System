package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Delete_Driver extends JFrame implements ActionListener{
	
	Choice carname;
	JTable table;
	JButton Back, delete;
	
	Delete_Driver(){
setLayout(null);
		
JLabel l1 = new JLabel("Name");
l1.setBounds(0,10,80,20);
add(l1);

JLabel l2 = new JLabel("Age");
l2.setBounds(150,10,80,20);
add(l2);

JLabel l3 = new JLabel("Gender");
l3.setBounds(300,10,80,20);
add(l3);

JLabel l4 = new JLabel("Company");
l4.setBounds(450,10,80,20);
add(l4);

JLabel l5 = new JLabel("Brand");
l5.setBounds(600,10,80,20);
add(l5);

JLabel l6 = new JLabel("Availability");
l6.setBounds(750,10,80,20);
add(l6);

JLabel l7 = new JLabel("Location");
l7.setBounds(900,10,80,20);
add(l7);
		
		table = new JTable();
		table.setBounds(0, 40, 1050, 300);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from driver";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back To Dashboard");
		Back.addActionListener(this);
		Back.setBounds(50, 500, 200, 30);
		add(Back);
		
		delete = new JButton("Delete Record");
		delete.addActionListener(this);
		delete.setBounds(450, 500, 200, 30);
		delete.setForeground(Color.RED);
		add(delete);
		
		JLabel lblroom = new JLabel("Select Employee Which you want to remove: ");
		lblroom.setBounds(65, 400, 300, 20);
		add(lblroom); 
		
		carname = new Choice();
		carname.setBounds(370,400,150,25);
		add(carname);
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "select * from driver";
			
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				carname.add(rs.getString("brand"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setBounds(300, 200, 1050, 600);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == Back) {
	    	setVisible(false);
	    } else if(e.getSource() == delete) {
			
			try {
				DBConnection c = new DBConnection();
				String query = "delete from driver where brand = '"+carname.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Driver Record Deleted Successfully");
				
				setVisible(false);
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        	
	    } 
	}

	
	public static void main(String[] args) {
		new Delete_Driver();

	}

	

}
