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



public class Update_Check extends JFrame implements ActionListener{
	
	JLabel text, lblid, lblroom, lblname, lbltime, lblpending, lblpaid;
	Choice ccustomer;
	JTextField tfroom, tfname, tftime,tfpending, tfpaid;
	JButton update, check, back;
	
	Update_Check(){
		setLayout(null);
		
		text = new JLabel("UPDATE STATUS");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(90, 20, 200, 30);
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
		
		lblname = new JLabel("Guest Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblname.setBounds(30, 160, 150, 20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 160, 150, 25);
		add(tfname);
		
		lbltime = new JLabel("Checkin Time");
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltime.setBounds(30, 200, 150, 20);
		add(lbltime);
		
		tftime = new JTextField();
		tftime.setBounds(200, 200, 150, 25);
		add(tftime);
		
		lblpaid = new JLabel("Amount Paid");
		lblpaid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpaid.setBounds(30, 240, 150, 20);
		add(lblpaid);
		
		tfpaid = new JTextField();
		tfpaid.setBounds(200, 240, 150, 25);
		add(tfpaid);
		
		lblpending = new JLabel("Amount Pending");
		lblpending.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpending.setBounds(30, 280, 150, 20);
		add(lblpending);
		
		tfpending = new JTextField();
		tfpending.setBounds(200, 280, 150, 25);
		add(tfpending);
		
		check = new JButton("Check");
		check.setBounds(30, 340, 100, 30);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Update");
		update.setBounds(140, 340, 100, 30);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(250, 340, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Management System/src/icons/nine.jpg");		
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
	                tfname.setText(rs.getNString("name"));
	                tftime.setText(rs.getNString("chekintime"));
	                tfpaid.setText(rs.getNString("deposite"));
	            }
	            
	            ResultSet rs2 = c.s.executeQuery("select * from room where room_no = '"+tfroom.getText()+"'");
	            
	            while(rs2.next()) {
	                String price = rs2.getString("price");
	                int totalAmount = Integer.parseInt(price);
	                int amountPaid = Integer.parseInt(tfpaid.getText());
	                int pendingAmount = totalAmount - amountPaid;
	                tfpending.setText(String.valueOf(pendingAmount));
	            }

	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    } else if(ae.getSource() == update) {
	        String number = ccustomer.getSelectedItem();
	        String room = tfroom.getText();
	        String name = tfname.getText();
	        String checkin = tftime.getText();
	        String paid = tfpaid.getText();
//	        String pending = tfpending.getText();

	        try {
	            DBConnection c = new DBConnection();

//	            String query = "update customer set room='"+room+"', name='"+name+"', chekintime='"+checkin+"', deposite='"+paid+"', pending='"+pending+"' where number='"+number+"'";
	            
	            String query = "update customer set room='"+room+"', name='"+name+"', chekintime='"+checkin+"', deposite='"+paid+"' where number='"+number+"'";
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
		new Update_Check();

	}

	

}
