package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
	
	JButton logout, quit;
			
	Dashboard(){
		setBounds(0,0, 1550, 1000);
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("src/icons/third.jpg");
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 1000);
		add(image);
		
		JLabel text = new JLabel("Experience The Royal Treatment - TAJ Group");
		text.setBounds(200, 80, 10000, 50);
		image.add(text);
		text.setForeground(Color.yellow);
		text.setFont(new Font("Times New Roman", Font.BOLD, 50));

		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1440, 30);
		image.add(mb);
		
		JMenu hotel = new JMenu("Hotel Management");
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("Reception");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu("Admin");
		mb.add(admin);
		
		JMenuItem addEmployee = new JMenuItem("Add Employee Data");
		addEmployee.addActionListener(this);
		admin.add(addEmployee);
		
		JMenuItem dlt_Employee = new JMenuItem("Delete Employee Data");
		dlt_Employee.addActionListener(this);
		admin.add(dlt_Employee);
		
		JMenuItem addRoom = new JMenuItem("Add Room");
		addRoom.addActionListener(this);
		admin.add(addRoom);
		
		JMenuItem dltRoom = new JMenuItem("Delete Room");
		dltRoom.addActionListener(this);
		admin.add(dltRoom);
		
		JMenuItem addDriver = new JMenuItem("Add Driver Data");
		addDriver.addActionListener(this);
		admin.add(addDriver);
		
		JMenuItem dltDriver = new JMenuItem("Delete Driver Data");
		dltDriver.addActionListener(this);
		admin.add(dltDriver);
		
		JMenu a = new JMenu("                                                                                                                                                                                                                                                                   ");
		a.addActionListener(this);
		mb.add(a);
		
		logout = new JButton("Logout");
		logout.addActionListener(this);
//		mb.setBounds(1300, 0, 200, 20);
		logout.setForeground(Color.RED);
		mb.add(logout);
		
		quit = new JButton("Quit");
		quit.addActionListener(this);
		quit.setBounds(1270, 0, 200, 20);
//		quit.setForeground(Color.MAGENTA);
		mb.add(quit);

		setVisible(true);
		setBounds(100, 0, 1240, 900);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Add Employee Data")) {
			new Add_Employee();
		}else if(ae.getActionCommand().equals("Add Room")) {
			new Add_Rooms();
		}else if(ae.getActionCommand().equals("Add Driver Data")) {
			new Add_Driver();
		}else if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}else if(ae.getActionCommand().equals("Delete Employee Data")) {
			new Delete_Employee();
		}else if(ae.getSource() == logout) {
			setVisible(false);
			new Login();
		}else if(ae.getSource() == quit) {
			setVisible(false);
			System.exit(0);
		}else if(ae.getActionCommand().equals("Delete Driver Data")) {
			new Delete_Driver();
		}else if(ae.getActionCommand().equals("Delete Room")) {
			new Delete_Room();
		}
		
	}

	public static void main(String[] args) {
		new Dashboard();

	}


}
