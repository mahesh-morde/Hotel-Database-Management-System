package hotel.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener{
	
	JButton cancel, quit, logout, pickup, newCustomer, rooms, department, allEmployee, customers, managerInfo, checkout, update, roomStatus, searchRoom;
	
	Reception(){
		
		setLayout(null);
		
		newCustomer = new JButton("New Customer Form");
		newCustomer.setBounds(10,30,200,30);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms = new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.addActionListener(this);
		add(rooms);
		
		department = new JButton("Department");
		department.setBounds(10,110,200,30);
		department.addActionListener(this);
		add(department);
		
		allEmployee = new JButton("All Emloyee");
		allEmployee.setBounds(10,150,200,30);
		allEmployee.addActionListener(this);
		add(allEmployee);
		
		customers = new JButton("Customer Details");
		customers.setBounds(10,190,200,30);
		customers.addActionListener(this);
		add(customers );
		
		managerInfo = new JButton("Manager Information");
		managerInfo.setBounds(10,230,200,30);
		managerInfo.addActionListener(this);
		add(managerInfo );
		
		checkout = new JButton("Checkout");
		checkout.setBounds(10,270,200,30);
		checkout.addActionListener(this);
		add(checkout);
		
		update = new JButton("Update Status");
		update.setBounds(10,310,200,30);
		update.addActionListener(this);
		add(update);
		
		roomStatus = new JButton("Update Room Status");
		roomStatus.setBounds(10,350,200,30);
		roomStatus.addActionListener(this);
		add(roomStatus);
		
		pickup = new JButton("Pickup Service");
		pickup.setBounds(10,390,200,30);
		pickup.addActionListener(this);
		add(pickup);
		
		searchRoom = new JButton("Search Rooms");
		searchRoom.setBounds(10,430,200,30);
		searchRoom.addActionListener(this);
		add(searchRoom);
		
//		logout = new JButton("Logout");
//		logout.setBounds(10,470,200,30);
//		logout.addActionListener(this);
//		add(logout);
		
		cancel = new JButton("Back To Dashboard");
		cancel.setBounds(10,470,200,30);
		cancel.setForeground(Color.MAGENTA);
		cancel.addActionListener(this);
		add(cancel);
		
		quit = new JButton("Quit");
		quit.setBounds(10,510,200,30);
		quit.setForeground(Color.RED);
		quit.addActionListener(this);
		add(quit);
		
		ImageIcon i1 = new ImageIcon("src/icons/fourth.jpg");		
		JLabel image = new JLabel(i1);
		image.setBounds(250, 30, 500, 510);
		add(image);
		
		setBounds(350, 200, 800, 590);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == newCustomer) {
			setVisible(false);
			new Add_Customer();
		}else if(ae.getSource() == rooms) {
			setVisible(false);
			new Room();
		}else if(ae.getSource() == department) {
			setVisible(false);
			new Department();
		}else if(ae.getSource() == allEmployee) {
			setVisible(false);
			new EmployeeInfo();
		}else if(ae.getSource() == managerInfo) {
			setVisible(false);
			new ManagerInfo();
		}else if(ae.getSource() == customers) {
			setVisible(false);
			new CustomerInfo();
		}else if(ae.getSource() == searchRoom) {
			setVisible(false);
			new Search_Room();
		}else if(ae.getSource() == roomStatus) {
			setVisible(false);
			new Update_Room();
		}else if(ae.getSource() == pickup) {
			setVisible(false);
			new Pickup();
		}else if(ae.getSource() == checkout) {
			setVisible(false);
			new Checkout();
		}else if(ae.getSource() == quit) {
			setVisible(false);
			System.exit(0);
		}else if(ae.getSource() == update) {
			setVisible(false);
			new Update_Check();
//		}else if(ae.getSource() == logout) {
//			setVisible(false);
//			System.exit(0);
		}else if(ae.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Reception();
	}

}
