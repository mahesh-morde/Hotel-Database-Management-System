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

public class Delete_Employee extends JFrame implements ActionListener{
	
	Choice empname;
	JTable table;
	JButton Back, delete, cancel;
	
	Delete_Employee(){
setLayout(null);
		
		JLabel l1 = new JLabel("Employee Name");
		l1.setBounds(0,10,131,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(131,10,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(262,10,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Job");
		l4.setBounds(393,10,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Salary");
		l5.setBounds(524,10,80,20);
		add(l5);
		
		JLabel l6 = new JLabel("Phon No");
		l6.setBounds(656,10,80,20);
		add(l6);
		
		JLabel l7 = new JLabel("Email");
		l7.setBounds(787,10,80,20);
		add(l7);
		
		JLabel l8 = new JLabel("Address");
		l8.setBounds(918,10,80,20);
		add(l8);
		
		table = new JTable();
		table.setBounds(0, 40, 1050, 300);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from employee";
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
		
		empname = new Choice();
		empname.setBounds(370,400,150,25);
		add(empname);
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "select * from employee";
			
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				empname.add(rs.getString("name"));
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
				String query = "delete from employee where name = '"+empname.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Employee Record Deleted Successfully");
				
				setVisible(false);
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        	
	    } 
	}

	
	public static void main(String[] args) {
		new Delete_Employee();

	}

	

}
