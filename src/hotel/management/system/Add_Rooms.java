package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Add_Rooms extends JFrame implements ActionListener{
	
	JTextField tfroomno, tfprice;
	JButton Add_Room, cancel;
	JComboBox availablecombo,cleancombo,roomcombo;
	
	Add_Rooms(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 40, 200, 20);
		add(heading);
		
		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomno.setBounds(70, 90, 200, 20);
		add(lblroomno);
		
		tfroomno = new JTextField();
		tfroomno.setBounds(220 , 90, 200, 20);
		add(tfroomno);
		
		JLabel lblavailable = new JLabel("Room Available ?");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblavailable.setBounds(70, 140, 200, 20);
		add(lblavailable);
		
		String availableoptions[] = {"Available" , "Occupied"};
		availablecombo = new JComboBox(availableoptions);
		availablecombo.setBounds(220, 140, 200, 20);
		add(availablecombo);
		
		JLabel lblstatus = new JLabel("Cleanng Status");
		lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus.setBounds(70, 180, 200, 20);
		add(lblstatus);
		
		String cleanoptions[] = {"Cleaned" , "Dirty"};
		cleancombo = new JComboBox(cleanoptions);
		cleancombo.setBounds(220, 180, 200, 20);
		add(cleancombo);
		
		JLabel lblprice = new JLabel("Room Price");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice.setBounds(70, 220, 200, 20);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(220 , 220, 200, 20);
		add(tfprice);
		
		JLabel lbltype = new JLabel("Room Type");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltype.setBounds(70, 260, 200, 20);
		add(lbltype);
		
		String roomoptions[] = {"Single bed" , "Double bed"};
		roomcombo = new JComboBox(roomoptions);
		roomcombo.setBounds(220, 260, 200, 20);
		add(roomcombo);
		
		Add_Room= new JButton("Add Room");
		Add_Room.setBounds(250, 320, 150, 20);
		Add_Room.setBackground(Color.BLACK);
		Add_Room.addActionListener(this); 
		add(Add_Room);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(70, 320, 150, 20);
		cancel.setBackground(Color.BLACK);
		cancel.addActionListener(this); 
		add(cancel);
		
		ImageIcon i1 = new ImageIcon("src/icons/twelve.jpg");
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(440, 30, 450, 370);
		add(image);
		
		
		setBounds(330, 200, 940, 470);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== Add_Room) {
			
			String room_no = tfroomno.getText();
			String roomprice = tfprice.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String cleanstatus = (String) cleancombo.getSelectedItem();
			String roomtype = (String) roomcombo.getSelectedItem();
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "insert into room values ('"+room_no+"','"+availability+"','"+cleanstatus+"','"+roomprice+"','"+roomtype +"')";
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "New Room Added Sucessfully");
				
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new Add_Rooms();

	}

}
