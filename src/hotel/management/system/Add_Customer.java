package hotel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class Add_Customer extends JFrame implements ActionListener{
	
	JComboBox comboid;
	JTextField tfNumber, tfname, tfcountry, tfDeposite;
	JRadioButton rmale, rfemale;
	Choice croom;
	JButton Add, Back;
	JLabel lblcurentcheckintime;
	
	Add_Customer(){
		setLayout(null);
		
		JLabel lblnewcustform = new JLabel("NEW CUSTOMER FORM");
		lblnewcustform.setBounds(100, 20, 300, 30);
		lblnewcustform.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblnewcustform);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(35, 80, 100, 20);
		lblid.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblid);
		 
		String options []= {"Aadhar Card", "Passport", "Driving License", "Pancard", "VoterID"};
		comboid = new JComboBox (options);
		comboid.setBounds(200, 80, 150, 25);
		add(comboid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(35, 120, 100, 20);
		lblnumber.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblnumber); 
		
		tfNumber = new JTextField();
		tfNumber.setBounds(200, 120, 150, 25);
		add(tfNumber);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(35, 160, 100, 20);
		lblname.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblname); 
		
		tfname = new JTextField();
		tfname.setBounds(200, 160, 150, 25);
		add(tfname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(35, 200, 100, 20);
		lblgender.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblgender);
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(200, 200, 600, 25);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(270, 200, 600, 25);
		add(rfemale);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(35, 240, 100, 20);
		lblcountry.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblcountry); 
		
		tfcountry = new JTextField();
		tfcountry.setBounds(200, 240, 150, 25);
		add(tfcountry);
		
		
		
		JLabel lblroom = new JLabel("Room");
		lblroom.setBounds(35, 280, 100, 20);
		lblroom.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblroom); 
		
		croom = new Choice();
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "select * from room where availability = 'Available'";
			
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				croom.add(rs.getString("room_no"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		croom.setBounds(200,280,150,25);
		add(croom);
		
		
		
		JLabel lblcheckintime = new JLabel("Checkin Time");
		lblcheckintime.setBounds(35, 320, 100, 20);
		lblcheckintime.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblcheckintime); 
		
		Date date = new Date(); 
		
		lblcurentcheckintime = new JLabel(""+ date);
		lblcurentcheckintime.setBounds(205, 320, 1000, 20);
		lblcurentcheckintime.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblcurentcheckintime); 
		
		
		JLabel lblDeposite = new JLabel("Deposite");
		lblDeposite.setBounds(35, 360, 100, 20);
		lblDeposite.setFont(new Font("Releway", Font.PLAIN, 20));
		add(lblDeposite); 
		
		tfDeposite = new JTextField();
		tfDeposite.setBounds(200, 360, 150, 25);
		add(tfDeposite);
		
		Add = new JButton("Add");
		Add.setBounds(50, 410, 120, 25);
		Add.setBackground(Color.BLACK);
		Add.addActionListener(this); 
		add(Add);
		
		Back= new JButton("Back");
		Back.setBounds(200, 410, 120, 25);
		Back.setBackground(Color.BLACK);
		Back.addActionListener(this); 
		add(Back);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Management System/src/icons/fifth.png");
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(490, 40, 300, 400);
		add(image);
		
		
		setBounds(350, 200, 800, 550);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Add) {
			String ID = (String) comboid.getSelectedItem();
			String Number  = tfNumber.getText();
			String Name  = tfname.getText();
			String Country  = tfcountry.getText();
			String Deposite  = tfDeposite.getText();
			String Gender = null;
			
			if(rmale.isSelected()) {
				Gender = "Male";
			}else {Gender = "Female";
					}
			 
			String Room = croom.getSelectedItem();
			String Time = lblcurentcheckintime.getText();
			
			
			
			try {
				DBConnection c = new DBConnection();
				
				String query1 = "INSERT INTO customer VALUES ('" + ID + "','" + Number + "','" + Name + "','" + Gender + "','" + Country + "','" + Room + "','" + Time + "'," + Deposite + ")";
				String query2 = "update room set availability = 'Occupied' where room_no = '"+Room+"'";
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Room Allocated Successfuly");
				
				setVisible(false);
				new Reception();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
					
					
			
		}else if(ae.getSource()==Back) {
			setVisible(false);
			new Reception();
			
		}
		
	}

	public static void main(String[] args) {
		new Add_Customer();

	}

}
