package hotel.management.system;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;



public class Update_Room extends JFrame implements ActionListener{
	
	JLabel text, lblid, lblroom, lblavailable, lblcleanstatus;
	Choice ccustomer;
	JTextField tfroom, tfavailable, tfcleanstatus;
	JButton update, check, back;
	
	Update_Room(){
		setLayout(null);
		
		text = new JLabel("UPDATE ROOM STATUS");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(30, 20, 250, 30);
		add(text);
		
		lblid = new JLabel("Customer ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblid.setBounds(30, 80, 130, 20);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200, 80, 150, 25);
		add(ccustomer);
		
		try {
			DBConnection c = new DBConnection();
			
			String query = "select * from customer";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		lblroom = new JLabel("Room Number");
		lblroom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblroom.setBounds(30, 120, 150, 20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200, 120, 150, 25);
		add(tfroom);
		
		lblavailable = new JLabel("Availability");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblavailable.setBounds(30, 160, 150, 20);
		add(lblavailable);
		
		tfavailable = new JTextField();
		tfavailable.setBounds(200, 160, 150, 25);
		add(tfavailable);
		
		lblcleanstatus = new JLabel("Cleaning Status");
		lblcleanstatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblcleanstatus.setBounds(30, 200, 150, 20);
		add(lblcleanstatus);
		
		tfcleanstatus = new JTextField();
		tfcleanstatus.setBounds(200, 200, 150, 25);
		add(tfcleanstatus);
		
		
		check = new JButton("Check");
		check.setBounds(30, 300, 100, 30);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBounds(140, 300, 100, 30);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(250, 300, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon("src/icons/seventh.jpg");		
		JLabel image = new JLabel(i1);
		image.setBounds(400, 50, 500, 300);
		add(image);
		
		setBounds(300, 200, 950, 450);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
	    if(ae.getSource() == check) {
	        String id = ccustomer.getSelectedItem();
	        String query = "select * from customer where number = '"+id+"'";

	        try {
	            DBConnection c = new DBConnection();
	            ResultSet rs = c.s.executeQuery(query);

	            while (rs.next()) {
	                tfroom.setText(rs.getNString("room"));	            
	            }
	            
	            ResultSet rs2 = c.s.executeQuery("select * from room where room_no = '"+tfroom.getText()+"'");
	            
	            while(rs2.next()) {
	            	tfavailable.setText(rs2.getString("availability"));
	            	tfcleanstatus.setText(rs2.getString("cleaning_status"));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    } else if(ae.getSource() == update) {
	        String room = tfroom.getText();
	        String available = tfavailable.getText();
	        String status = tfcleanstatus.getText();
	       

	        try {
	            DBConnection c = new DBConnection();

	            String query = "update room set availability='"+available+"', cleaning_status='"+status+"' where room_no='"+room+"'";
	            c.s.executeUpdate(query);

	            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
	            
	            setVisible(false);
	            new Reception();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else if(ae.getSource() == back) {
	    	setVisible(false);
            new Reception();
	    }
	}


	public static void main(String[] args){
		new Update_Room();

	}

	

}
