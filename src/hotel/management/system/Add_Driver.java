package hotel.management.system;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Add_Driver extends JFrame implements ActionListener{
	
	JTextField tfname, tfage, tfcompany, tfcarmodel, tflocation;
	JButton Add_Driver, cancel;
	JComboBox gendercombo, driveravailablecombo ;
	
	Add_Driver(){
		
		setLayout(null);
		
		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 40, 200, 20);
		add(heading);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblname.setBounds(70, 90, 200, 20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(220 , 90, 200, 20);
		add(tfname);
		
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblage.setBounds(70, 125, 200, 20);
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(220, 125, 200, 20);
		add(tfage);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgender.setBounds(70, 175, 200, 20);
		add(lblgender);
		
		String genderoptions[] = {"Male" , "Female"};
		gendercombo = new JComboBox(genderoptions);
		gendercombo.setBounds(220, 175, 200, 20);
		add(gendercombo);
		
		JLabel lblcompany = new JLabel("Car Company");
		lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcompany.setBounds(70, 220, 200, 20);
		add(lblcompany);
		
		tfcompany = new JTextField();
		tfcompany.setBounds(220 , 220, 200, 20);
		add(tfcompany);
		
		JLabel lblcarmodel = new JLabel("Car Model");
		lblcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcarmodel.setBounds(70, 260, 200, 20);
		add(lblcarmodel);
		
		tfcarmodel = new JTextField();
		tfcarmodel.setBounds(220 , 260, 200, 20);
		add(tfcarmodel);
		
		JLabel lblavailable = new JLabel("Availability");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblavailable.setBounds(70, 300, 200, 20);
		add(lblavailable);
		
		String driveravaillableoptions[] = {"Available" , "Busy"};
		driveravailablecombo = new JComboBox(driveravaillableoptions);
		driveravailablecombo.setBounds(220, 300, 200, 20);
		add(driveravailablecombo);
		
		JLabel lbllocation = new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbllocation.setBounds(70, 340, 200, 20);
		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(220 , 340, 200, 20);
		add(tflocation);
		
		
		Add_Driver= new JButton("Add Details");
		Add_Driver.setBounds(250, 390, 150, 20);
		Add_Driver.addActionListener(this); 
		add(Add_Driver);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(70, 390, 150, 20);
		cancel.addActionListener(this); 
		add(cancel);
		
		ImageIcon i1 = new ImageIcon("/Users/maheshmorde/Applications/Hotel Management System/src/icons/eleven.jpg");
		Image i2 = i1.getImage().getScaledInstance(630, 420, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(440, 45, 530, 370);
		add(image);
		
		
		setBounds(300, 200, 980, 470);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== Add_Driver) {
			
			String name = tfname.getText();
			String age = tfage.getText();
			String company = tfcompany.getText();
			String gender = (String) gendercombo.getSelectedItem();
			String model = tfcarmodel .getText();
			String available = (String) driveravailablecombo.getSelectedItem();
			String Location = tflocation.getText();
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "insert into driver values ('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+Location+"')";
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Driver Details Added Sucessfully");
				
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new Add_Driver();

	}

}
