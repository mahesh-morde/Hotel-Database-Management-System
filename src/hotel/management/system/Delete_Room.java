package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Delete_Room extends JFrame implements ActionListener{
	
	Choice roomno;
	JTable table;
	JButton Back, delete, cancel;
	
	Delete_Room(){
setLayout(null);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Database Management System/src/icons/eight.jpg");
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
		l3.setBounds(200,10,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(300,10,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(400,10,80,20);
		add(l5);
		
		table = new JTable();
		table.setBounds(0, 40, 500, 350);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from room";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back To Dashboard");
		Back.addActionListener(this);
		Back.setBounds(5, 500, 150, 30);
		add(Back);
		
		delete = new JButton("Delete Room");
		delete.addActionListener(this);
		delete.setBounds(200, 500, 150, 30);
		delete.setForeground(Color.RED);
		add(delete);
		
		JLabel lblroom = new JLabel("Select Room No. To remove: ");
		lblroom.setBounds(10, 420, 190, 20);
		add(lblroom); 
		
		roomno = new Choice();
		roomno.setBounds(200,420,150,25);
		add(roomno);
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "select * from room";
			
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				roomno.add(rs.getString("room_no"));
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
				String query = "delete from room where room_no = '"+roomno.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Room Removed from Database");
				
				setVisible(false);
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        	
	    } 
	}

	
	public static void main(String[] args) {
		new Delete_Room();

	}

	

}
