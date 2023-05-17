package hotel.management.system;
import javax.swing.*;
import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Pickup extends JFrame implements ActionListener{
	
	JTable table;
	JButton Back, submit;
	JLabel lblbedtype, lblcartype;
	Choice typeofcar;
	JCheckBox available;
	
	Pickup(){
		setLayout(null);
		
		JLabel text = new JLabel("Pickup Service");
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text.setBounds(400, 30, 200, 30);
		add(text);
		
		lblcartype = new JLabel("Type Of Car");
		lblcartype.setBounds(50, 100, 80, 20);
		add(lblcartype);
		
		typeofcar = new Choice();
		typeofcar.setBounds(150, 95, 200, 30);
		add(typeofcar);
		
		try {
			DBConnection c = new DBConnection();
			
			ResultSet rs = c.s.executeQuery("select * from driver");
			
			while(rs.next()) {
				typeofcar.add(rs.getNString("brand"));
			}
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(0,160,80,20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(150,160,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(300,160,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Company");
		l4.setBounds(450,160,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Brand");
		l5.setBounds(600,160,80,20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(750,160,80,20);
		add(l6);
		
		JLabel l7 = new JLabel("Location");
		l7.setBounds(900,160,80,20);
		add(l7);
		
		table = new JTable();
		table.setBounds(0, 200, 1050, 300);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from driver ";
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
				
				String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
				
				DBConnection c = new DBConnection();
				ResultSet rs;
				
					rs = c.s.executeQuery(query);
				
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
		new Pickup();

	}

	

}
