package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
	
	JButton logout, quit, quit1;
			
	Dashboard(){
		setBounds(0,0, 1550, 1000);
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Management System/src/icons/third.jpg");
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		add(image);
		
		JLabel text = new JLabel("Experience The Royal Treatment - TAJ Group");
		text.setBounds(300, 80, 10000, 50);
		image.add(text);
		text.setBackground(Color.BLUE);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Times New Roman", Font.BOLD, 50));

		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1550, 30);
		image.add(mb);
		
		
		JMenu hotel = new JMenu("Hotel Management");
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("Reception");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu("Admin");
		mb.add(admin);
		
		JMenuItem addEmployee = new JMenuItem("Add Employee");
		addEmployee.addActionListener(this);
		admin.add(addEmployee);
		
		JMenuItem addRoom = new JMenuItem("Add Room");
		addRoom.addActionListener(this);
		admin.add(addRoom);
		
		JMenuItem addDriver = new JMenuItem("Add Driver");
		addDriver.addActionListener(this);
		admin.add(addDriver);
		
		
		logout = new JButton("Logout");
		logout.addActionListener(this);
		logout.setForeground(Color.RED);
		mb.add(logout);
		
		quit = new JButton("Quit");
		quit.addActionListener(this);
		quit.setForeground(Color.MAGENTA);
		mb.add(quit);
		

		setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Add Employee")) {
			new Add_Employee();
		}else if(ae.getActionCommand().equals("Add Room")) {
			new Add_Rooms();
		}else if(ae.getActionCommand().equals("Add Driver")) {
			new Add_Driver();
		}else if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}else if(ae.getSource() == logout) {
			setVisible(false);
			new Login();
		}else if(ae.getSource() == quit) {
			setVisible(false);
			System.exit(0);
		}
		
	}

	public static void main(String[] args) {
		new Dashboard();

	}


}
