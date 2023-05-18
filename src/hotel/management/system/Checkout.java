package hotel.management.system;
import javax.swing.*;
import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
	
	JTable table;
	JButton Back, CheckOut;
	JLabel lblchekouttime, lblchekouttime1, lblcheckin,lblid, text, lblroom, lblroomno,lblchekintime;
	Choice ccustomer;
	JCheckBox available;
	int NUMBER;
	
	Checkout(){
		setLayout(null);
		
		text = new JLabel("Checkout");
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text.setBounds(100, 20, 100, 30);
		add(text);
		
		lblid = new JLabel("Customer ID");
		lblid.setBounds(30, 80, 100, 30);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(150, 80, 150, 25);
		add(ccustomer); 
		
		ImageIcon i1 = new ImageIcon("src/icons/tick.png");		
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(310, 80, 20, 20);
		add(image);
		
		lblroom = new JLabel("Room No");
		lblroom.setBounds(30, 130, 100, 30);
		add(lblroom);
		
		lblroomno = new JLabel();
		lblroomno.setBounds(150, 130, 100, 30);
		add(lblroomno);
		
		lblchekintime = new JLabel("Checkin Time");
		lblchekintime.setBounds(30, 180, 100, 30);
		add(lblchekintime);
		
		lblcheckin = new JLabel();
		lblcheckin.setBounds(150, 180, 500, 30);
		add(lblcheckin);
		
		lblchekouttime = new JLabel("Checkout Time");
		lblchekouttime.setBounds(30, 230, 100, 30);
		add(lblchekouttime);
		
		Date date = new Date();
		lblchekouttime1 = new JLabel(""+date);
		lblchekouttime1.setBounds(150, 230, 500, 30);
		add(lblchekouttime1);
		
		Back = new JButton("Back To Reception");
		Back.addActionListener(this);
		Back.setBounds(20, 300, 150, 30);
		add(Back);
		
		CheckOut = new JButton("CheckOut");
		CheckOut.addActionListener(this);
		CheckOut.setBounds(185, 300, 150, 30);
		add(CheckOut);
		
		ImageIcon i4 = new ImageIcon("src/icons/sixth.jpg");		
		Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(350, 50, 400, 250);
		add(image1);
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "select * from customer";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
				lblroomno.setText(rs.getString("room"));
				lblcheckin.setText(rs.getString("chekintime"));
				NUMBER = Integer.parseInt("number");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setBounds(300, 200, 800, 400);
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Back) {
			setVisible(false);
			 new Reception();
		}else {
			String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
			String query2 = "update room set availability = 'Available' where room_no = '"+lblroomno.getText()+"'";
		
			try {
				DBConnection c = new DBConnection();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "CheckeOut Done Successfully");
				setVisible(false);
				 new Reception();
				
			}catch(Exception ae) {
				ae.printStackTrace();
			}
		
		}

		
	}
	
	public static void main(String[] args) {
		new Checkout();

	}
}